package com.example.demo.domain.book;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;

@Service
public class BookService {
  private final List<BookEntity> books = new ArrayList<>();
  private final AtomicLong idGenerator = new AtomicLong(0);
  public List<Book> findAll() {
    return books.stream().map(BookEntity::toDomain).toList();
  }

  public void create(CreateBook book) {
    books.add(new BookEntity(idGenerator.incrementAndGet(), book));
  }
  public void delete(long id) {
    Book byId = getById(id);
    books.remove(BookEntity.fromDomain(byId));
  }
  public Book getById(long id) {
    return books.stream().filter(b->b.id()==id).findFirst().orElseThrow(IllegalArgumentException::new).toDomain();
  }

  public void modify(long id, ModifyBook modifyBook) {
    Book byId = getById(id);
    byId.modify(modifyBook);
  }

}
