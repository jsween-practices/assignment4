package com.example.demo.domain.book;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.ZonedDateTime;

@Entity
@Table(name = "books")
class BookEntity {

    public BookEntity() {
    }

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    private Integer publicationYear;
    private ZonedDateTime createdAt;

    private BookEntity(Long id, String title, String author, int publicationYear,
        ZonedDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.createdAt = createdAt;
    }

    static BookEntity fromDomain(Book book) {
        return new BookEntity(book.id(), book.title(), book.author(), book.publicationYear(),
            book.createdAt());
    }

    public Book toDomain() {
        return new Book(id, title, author, publicationYear, createdAt);
    }

    public BookEntity(long id, CreateBook createBook) {
        this(id, createBook.title(), createBook.author(), createBook.publicationYear(),
            ZonedDateTime.now());
    }

    public void modify(ModifyBook modifyBook) {
        title = modifyBook.title();
        author = modifyBook.author();
        publicationYear = modifyBook.publicationYear();
    }

    public Long id() {
        return id;
    }

    public String title() {
        return title;
    }

    public String author() {
        return author;
    }

    public int publicationYear() {
        return publicationYear;
    }

    public ZonedDateTime createdAt() {
        return createdAt;
    }
}
