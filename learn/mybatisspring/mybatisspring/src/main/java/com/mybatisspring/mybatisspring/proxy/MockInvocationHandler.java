package com.mybatisspring.mybatisspring.proxy;

import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MockInvocationHandler implements InvocationHandler {
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    Select annotation = method.getAnnotation(Select.class);
    if (annotation != null) {
      System.out.println("connect db");
      List<String> arraylist = new ArrayList<>();
      arraylist.add("linda");
      arraylist.add("judy");
      return arraylist;
    }

    return null;
  }
}
