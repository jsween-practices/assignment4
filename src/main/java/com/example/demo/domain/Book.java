package com.example.demo.domain;

public record Book(Long id, String title, String author, int publicationYear) {
  Book persist(long id) {
    return new Book(id, title, author, publicationYear);
  }
}
