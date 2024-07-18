package com.example.demo.api;

import com.example.demo.domain.book.BookService;
import java.util.List;
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
    private final BookService service;

    public BookApiController(BookService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateBookRequest request) {
        service.create(request.toDomain());
    }

    @GetMapping
    public List<BookResponse> findList() {
        return service.findAll().stream().map(BookResponse::fromDomain).toList();
    }

    @GetMapping("{id}")
    public BookResponse findOne(@PathVariable("id") long id) {
        return BookResponse.fromDomain(service.getById(id));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") long id) {
        service.delete(id);
    }

    @PutMapping("{id}")
    public void modifyContent(@PathVariable("id") long id, @RequestBody ModifyBookRequest request) {
        service.modify(id, request.toDomain());
    }


}
