package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;

@Service
public class BookService {
  private final List<Book> books = new ArrayList<>();
  private AtomicLong idGenerator = new AtomicLong(0);
  public List<Book> findAll() {
    return books;
  }

  public void create(Book book) {
    books.add(book.persist(idGenerator.incrementAndGet()));
  }
}
