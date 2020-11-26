package com.mybatisspring.mybatisspring.proxy;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MockFactoryBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

  @Override
  public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
      BeanDefinitionRegistry registry) {
    BeanDefinitionBuilder beanDefinitionBuilder =
        BeanDefinitionBuilder.genericBeanDefinition(MockFactoryBean.class);
    AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

    beanDefinition.getPropertyValues()
        .add("mapperInterface", "com.mybatisspring.mybatisspring.dao.BookDao");

    registry.registerBeanDefinition("mockFactoryBean", beanDefinition);
  }
}
