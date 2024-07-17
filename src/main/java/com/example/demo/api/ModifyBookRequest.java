package com.example.demo.api;

import com.example.demo.domain.book.ModifyBook;

public record ModifyBookRequest(String title, String author, int publicationYear) {
    ModifyBook toDomain(){
        return new ModifyBook(title, author, publicationYear);
    }
}
