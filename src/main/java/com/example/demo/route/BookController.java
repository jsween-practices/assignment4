package com.example.demo.route;

import com.example.demo.domain.book.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("book")
public class BookController {
  private final BookService service;

  public BookController(BookService service) {
    this.service = service;
  }

  @GetMapping("home")
  public String home(Model model) {
    model.addAttribute("books", service.findAll());
    return "books";
  }

  @GetMapping("create")
  public String getForm() {
    return "addBook";
  }
}
