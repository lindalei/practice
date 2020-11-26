package com.mybatisspring.mybatisspring;

import com.mybatisspring.mybatisspring.config.MockAppConfig;
import com.mybatisspring.mybatisspring.service.BookService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class MybatisspringApplication {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MockAppConfig.class);
    ac.getBean(BookService.class).getNames();
  }
}
