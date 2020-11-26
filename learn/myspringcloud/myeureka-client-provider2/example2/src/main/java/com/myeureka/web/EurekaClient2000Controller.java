package com.myeureka.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class EurekaClient2000Controller {

  @RequestMapping("index")
  @ResponseBody
  public Map<String, String> welcomeMap() {
    Map<String, String> map = new HashMap<>();
    map.put("today", "2000");
    return map;
  }
}
