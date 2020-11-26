package com.mybatisspring.mybatisspring.service;

import com.mybatisspring.mybatisspring.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
  @Autowired
  BookDao bookDao;


  public List<String> getNames() {
    System.out.println(bookDao.getNames());
    return bookDao.getNames();
  }
}
