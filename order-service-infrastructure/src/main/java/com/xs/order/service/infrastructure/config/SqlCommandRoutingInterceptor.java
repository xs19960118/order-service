package com.xs.order.service.infrastructure.config;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import java.util.Properties;

/**
 * MyBatis 拦截器: 根据 SQL 类型自动选择 master/slave (读写分离)
 * 规则:
 * 1. 已通过 @ReadOnly 指定 SLAVE 时不再覆盖
 * 2. 非 SELECT: master
 * 3. SELECT 且包含 for update / last_insert_id() / selectKey: master
 * 4. 其他 SELECT: slave (若有可用从库, 否则 master)
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, org.apache.ibatis.session.RowBounds.class, org.apache.ibatis.session.ResultHandler.class})
})
public class SqlCommandRoutingInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        SqlCommandType type = ms.getSqlCommandType();
        boolean already = DataSourceContextHolder.getRole() == DataSourceRole.SLAVE; // 注解已指定
        try {
            if (!already) {
                if (type != SqlCommandType.SELECT) {
                    DataSourceContextHolder.useMaster();
                } else {
                    // selectKey 生成主键的伪 SELECT, 走 master
                    if (ms.getId() != null && ms.getId().endsWith("!selectKey")) {
                        DataSourceContextHolder.useMaster();
                    } else {
                        BoundSql boundSql = ms.getBoundSql(args.length > 1 ? args[1] : null);
                        String sql = boundSql.getSql().toLowerCase();
                        if (sql.contains(" for update") || sql.contains("last_insert_id()")) {
                            DataSourceContextHolder.useMaster();
                        } else {
                            DataSourceContextHolder.useSlave();
                        }
                    }
                }
            }
            return invocation.proceed();
        } finally {
            if (!already) { // 仅自动设置的要清理, 保持注解作用域在方法内
                DataSourceContextHolder.clear();
            }
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) { }
}

