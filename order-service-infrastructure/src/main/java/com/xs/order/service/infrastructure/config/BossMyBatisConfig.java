package com.xs.order.service.infrastructure.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Boss 数据源 MyBatis 配置（主数据源）
 * 
 * Mapper 接口扫描路径：com.xs.order.service.infrastructure.persistence.mapper.boss
 * Mapper XML 文件路径：classpath:mapper/boss/*.xml
 *
 * @author xiangshang
 */
@Configuration
@MapperScan(
    basePackages = "com.xs.order.service.infrastructure.persistence.mapper.boss",
    sqlSessionFactoryRef = "bossSqlSessionFactory"
)
public class BossMyBatisConfig {

    /**
     * Boss SqlSessionFactory（主）
     */
    @Primary
    @Bean(name = "bossSqlSessionFactory")
    public SqlSessionFactory bossSqlSessionFactory(@Qualifier("bossDataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        
        // 设置 Mapper XML 文件位置
        sessionFactory.setMapperLocations(
            new PathMatchingResourcePatternResolver().getResources("classpath:mapper/boss/*.xml")
        );
        
        // 设置类型别名包路径
        sessionFactory.setTypeAliasesPackage("com.xs.order.service.infrastructure.persistence.po.boss");
        
        // MyBatis Plus 配置
        com.baomidou.mybatisplus.core.MybatisConfiguration configuration = new com.baomidou.mybatisplus.core.MybatisConfiguration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(false);
        sessionFactory.setConfiguration(configuration);
        
        return sessionFactory.getObject();
    }

    /**
     * Boss SqlSessionTemplate（主）
     */
    @Primary
    @Bean(name = "bossSqlSessionTemplate")
    public SqlSessionTemplate bossSqlSessionTemplate(@Qualifier("bossSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * Boss 事务管理器（主）
     */
    @Primary
    @Bean(name = "bossTransactionManager")
    public DataSourceTransactionManager bossTransactionManager(@Qualifier("bossDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}

