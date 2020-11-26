package com.mybatisspring.mybatisspring.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookDao {
  @Select("select name from book")
  List<String> getNames();
}
