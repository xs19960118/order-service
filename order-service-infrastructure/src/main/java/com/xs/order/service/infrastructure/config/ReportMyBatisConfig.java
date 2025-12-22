package com.xs.order.service.infrastructure.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Report 数据源 MyBatis 配置
 * <p>
 * Mapper 接口扫描路径：com.xs.order.service.infrastructure.persistence.mapper.report
 * Mapper XML 文件路径：classpath:mapper/report/*.xml
 *
 * @author xiangshang
 */
@Configuration
@MapperScan(
        basePackages = "com.xs.order.service.infrastructure.persistence.mapper.report",
        sqlSessionFactoryRef = "reportSqlSessionFactory"
)
public class ReportMyBatisConfig {

    /**
     * Report SqlSessionFactory
     */
    @Bean(name = "reportSqlSessionFactory")
    public SqlSessionFactory reportSqlSessionFactory(@Qualifier("reportDataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        // 设置 Mapper XML 文件位置
        sessionFactory.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mapper/report/*.xml")
        );

        // 设置类型别名包路径
        sessionFactory.setTypeAliasesPackage("com.xs.order.service.infrastructure.persistence.po.report");

        // MyBatis Plus 配置
        com.baomidou.mybatisplus.core.MybatisConfiguration configuration = new com.baomidou.mybatisplus.core.MybatisConfiguration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(false);
        sessionFactory.setConfiguration(configuration);

        return sessionFactory.getObject();
    }

    /**
     * Report SqlSessionTemplate
     */
    @Bean(name = "reportSqlSessionTemplate")
    public SqlSessionTemplate reportSqlSessionTemplate(@Qualifier("reportSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * Report 事务管理器
     */
    @Bean(name = "reportTransactionManager")
    public DataSourceTransactionManager reportTransactionManager(@Qualifier("reportDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}

