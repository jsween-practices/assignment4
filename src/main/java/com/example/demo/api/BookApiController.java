package com.example.demo.api;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookService;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookApiController {
  private final BookService service;

  public BookApiController(BookService service) {
    this.service = service;
  }

  @PostMapping
  public void create(@ModelAttribute Book book,  HttpServletResponse response) throws IOException {
    service.create(book);
    response.sendRedirect("/book/home");
  }
}
