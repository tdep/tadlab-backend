package com.tdep.tadlab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExampleController {

  @RequestMapping("/hello")
  @ResponseBody
  String home() {
    return "Hello World!";
  }
}
