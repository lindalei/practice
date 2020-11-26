package com.mybatisspring.mybatisspring.config;

import com.mybatisspring.mybatisspring.proxy.MockScanner;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.mybatisspring.mybatisspring")
@MockScanner("com.mybatisspring.mybatisspring.dao")
public class MockAppConfig {

}
