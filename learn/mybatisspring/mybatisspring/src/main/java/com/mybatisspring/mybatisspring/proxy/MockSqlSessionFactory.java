package com.mybatisspring.mybatisspring.proxy;

import java.lang.reflect.Proxy;

public class MockSqlSessionFactory {
  public static Object queryMapper(Class clazz) {
    Class[] classes = new Class[]{clazz};
    return Proxy.newProxyInstance(MockSqlSessionFactory.class.getClassLoader(), classes,
        new MockInvocationHandler());
  }
}
