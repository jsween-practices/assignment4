package com.example.demo.api.route;

import com.example.demo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

  @GetMapping("index")
  public String test(Model model) {
    User user = new User("jsween5723", "jsween5723@gmail.com", false);
    model.addAttribute("user", user);

    return "index";
  }
}
