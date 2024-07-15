package com.example.demo.api.route;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
  @GetMapping("index")
  public String test(Model model) {
    return "index";
  }
}