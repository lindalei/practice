package com.cloudExample1.cloudExample1.myspringcloud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Controller
public class EurekaLBController {
  @Autowired
  RestTemplate restTemplate;

  @RequestMapping("indexLB")
  @ResponseBody
  public String welcomeMap() {
    ResponseEntity<String> responseEntity =
        restTemplate.getForEntity("http://eureka-client-1000/index", String.class);

    return responseEntity.getBody();
  }
}
