//package com.mybatisspring.mybatisspring.config;
//
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import javax.sql.DataSource;
//
//@Configuration
//@ComponentScan("com.mybatisspring.mybatisspring")
//@MapperScan("com.mybatisspring.mybatisspring.dao")
//public class AppConfig {
//
//  @Bean
//  SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
//    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//    sqlSessionFactoryBean.setDataSource(dataSource);
//    return sqlSessionFactoryBean;
//  }
//
//  @Bean
//  DataSource dataSource() {
//    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//    driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/linda_schema");
//    driverManagerDataSource.setUsername("root");
//    driverManagerDataSource.setPassword("root");
//    return driverManagerDataSource;
//  }
//}
