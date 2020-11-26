package com.mybatisspring.mybatisspring.proxy;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Import(MockFactoryBeanDefinitionRegistrar.class)
public @interface MockScanner {
  String value();
}
