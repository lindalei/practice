package com.cloudExample1.cloudExample1.myspringcloud.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class EurekaClient1000Controller {
  @RequestMapping("index")
  @ResponseBody
  public Map<String, String> welcomeMap(){
    Map<String, String> map= new HashMap<>();
    map.put("today","1000");
    return map;
  }
}
