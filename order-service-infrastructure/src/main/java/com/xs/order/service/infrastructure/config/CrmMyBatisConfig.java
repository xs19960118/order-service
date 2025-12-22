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
 * CRM 数据源 MyBatis 配置
 * 
 * Mapper 接口扫描路径：com.xs.order.service.infrastructure.persistence.mapper.crm
 * Mapper XML 文件路径：classpath:mapper/crm/*.xml
 *
 * @author xiangshang
 */
@Configuration
@MapperScan(
    basePackages = "com.xs.order.service.infrastructure.persistence.mapper.crm",
    sqlSessionFactoryRef = "crmSqlSessionFactory"
)
public class CrmMyBatisConfig {

    /**
     * CRM SqlSessionFactory
     */
    @Bean(name = "crmSqlSessionFactory")
    public SqlSessionFactory crmSqlSessionFactory(@Qualifier("crmDataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        
        // 设置 Mapper XML 文件位置
        sessionFactory.setMapperLocations(
            new PathMatchingResourcePatternResolver().getResources("classpath:mapper/crm/*.xml")
        );
        
        // 设置类型别名包路径
        sessionFactory.setTypeAliasesPackage("com.xs.order.service.infrastructure.persistence.po.crm");
        
        // MyBatis Plus 配置
        com.baomidou.mybatisplus.core.MybatisConfiguration configuration = new com.baomidou.mybatisplus.core.MybatisConfiguration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(false);
        sessionFactory.setConfiguration(configuration);
        
        return sessionFactory.getObject();
    }

    /**
     * CRM SqlSessionTemplate
     */
    @Bean(name = "crmSqlSessionTemplate")
    public SqlSessionTemplate crmSqlSessionTemplate(@Qualifier("crmSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * CRM 事务管理器
     */
    @Bean(name = "crmTransactionManager")
    public DataSourceTransactionManager crmTransactionManager(@Qualifier("crmDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}

