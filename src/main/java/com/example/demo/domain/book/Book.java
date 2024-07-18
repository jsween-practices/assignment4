package com.example.demo.domain.book;

import java.time.ZonedDateTime;
import java.util.Objects;

public final class Book {

    private final Long id;
    private String title;
    private String author;
    private int publicationYear;
    private final ZonedDateTime createdAt;

    Book(Long id, String title, String author, int publicationYear, ZonedDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.createdAt = createdAt;
    }

    public Book(long id, CreateBook createBook) {
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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (Book) obj;
        return Objects.equals(this.id, that.id) && Objects.equals(this.title, that.title)
            && Objects.equals(this.author, that.author)
            && this.publicationYear == that.publicationYear && Objects.equals(this.createdAt,
            that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, publicationYear, createdAt);
    }

    @Override
    public String toString() {
        return "Book[" + "id=" + id + ", " + "title=" + title + ", " + "author=" + author + ", "
            + "publicationYear=" + publicationYear + ", " + "createdAt=" + createdAt + ']';
    }

}
