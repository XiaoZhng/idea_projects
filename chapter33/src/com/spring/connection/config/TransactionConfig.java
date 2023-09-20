package com.spring.connection.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Alonso
 */
@Configuration//配置类
@ComponentScan(basePackages = "com.spring.connection")//开启组件扫描
@EnableTransactionManagement//开启事务
public class TransactionConfig {

    //创建数据库连接池
    @Bean
    public DruidDataSource getDruidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/spring_db");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        return druidDataSource;
    }

    //创建 jdbcTemplate对象
    @Bean
    public JdbcTemplate getJdbcTemplate(DruidDataSource druidDataSource){
        //到 IOC容器中根据类型找到 dataSource
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //注入 dataSource
        jdbcTemplate.setDataSource(druidDataSource);
        return jdbcTemplate;
    }

    //创建事务管理器
    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DruidDataSource druidDataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(druidDataSource);
        return transactionManager;
    }
}
