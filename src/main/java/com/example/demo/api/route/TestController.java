package com.example.demo.api.route;

import com.example.demo.domain.Product;
import com.example.demo.domain.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

  @GetMapping("index")
  public String test(Model model) {
    User user = new User("jsween5723", "jsween5723@gmail.com", false);
    model.addAttribute("user", user);
    ArrayList<Product> products = new ArrayList<>();
    products.add(new Product(1L, "샘플1", 10));
    products.add(new Product(2L, "샘플2", 20));
    products.add(new Product(3L, "샘플3", 30));
    model.addAttribute("products", products);
    return "index";
  }
}
