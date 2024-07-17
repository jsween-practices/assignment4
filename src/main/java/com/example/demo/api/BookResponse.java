package com.example.demo.api;

import com.example.demo.domain.book.Book;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.ZonedDateTime;

public record BookResponse(long id, String title, String author, int publicationYear,
                           @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ") ZonedDateTime createdAt) {

    static BookResponse fromDomain(Book book) {
        return new BookResponse(book.id(), book.title(), book.author(), book.publicationYear(),
            book.createdAt());
    }
}
