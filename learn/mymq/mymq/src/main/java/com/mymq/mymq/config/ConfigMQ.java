package com.mymq.mymq.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.mymq.mymq.mapper")
public class ConfigMQ {

  @Bean
  Queue queue(){
    return new Queue("linda.queue");
  }

  @Bean
  TopicExchange exchange(){
    return new TopicExchange("linda.exchange");
  }

  @Bean
  Binding binding(){
   return BindingBuilder.bind(queue()).to(exchange()).with("linda.routing");
  }

    @Bean
    SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
      SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
      sqlSessionFactoryBean.setDataSource(dataSource);
      return sqlSessionFactoryBean;
    }

    @Bean
    DataSource dataSource() {
      DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
      driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
      driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/linda_schema");
      driverManagerDataSource.setUsername("root");
      driverManagerDataSource.setPassword("root");
      return driverManagerDataSource;
    }
}
