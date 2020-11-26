package com.mybatisspring.mybatisspring.proxy;

import org.springframework.beans.factory.FactoryBean;

public class MockFactoryBean implements FactoryBean {
  Class mapperInterface;

  @Override
  public Object getObject() throws Exception {
    return MockSqlSessionFactory.queryMapper(mapperInterface);
  }

  @Override
  public Class<?> getObjectType() {
    return mapperInterface;
  }

  public void setMapperInterface(Class mapperInterface) {
    this.mapperInterface = mapperInterface;
  }
}
