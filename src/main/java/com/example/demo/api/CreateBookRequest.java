package com.example.demo.api;

import com.example.demo.domain.book.CreateBook;

public record CreateBookRequest(String title, String author, int publicationYear) {
    CreateBook toDomain() {
        return new CreateBook(title, author, publicationYear);
    }
}
