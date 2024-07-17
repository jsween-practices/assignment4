package com.example.demo.api;

import com.example.demo.domain.book.Book;
import com.example.demo.domain.book.CreateBook;
import com.example.demo.domain.book.ModifyBook;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/books")
public class BookApiController {

    private final List<Book> books = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateBookRequest request) {
        create(request.toDomain());
    }

    @GetMapping
    public List<BookResponse> findList() {
        return findAll().stream().map(BookResponse::fromDomain).toList();
    }

    @GetMapping("{id}")
    public BookResponse findOne(@PathVariable("id") long id) {
        return BookResponse.fromDomain(getById(id));
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") long id) {
        delete(id);
    }

    @PutMapping("{id}")
    public void modifyContent(@PathVariable("id") long id, @RequestBody ModifyBookRequest request) {
        modify(id, request.toDomain());
    }


    private List<Book> findAll() {
        return books;
    }

    private void create(CreateBook book) {
        books.add(new Book(idGenerator.incrementAndGet(), book));
    }

    private void delete(long id) {
        Book byId = getById(id);
        books.remove(byId);
    }

    private Book getById(long id) {
        return books.stream().filter(b -> b.id() == id).findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }

    private void modify(long id, ModifyBook modifyBook) {
        Book byId = getById(id);
        byId.modify(modifyBook);
    }
}
