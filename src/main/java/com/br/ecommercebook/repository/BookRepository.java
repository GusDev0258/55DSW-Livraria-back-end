package com.br.ecommercebook.repository;

import com.br.ecommercebook.entity.Book;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

  Book findByName(String name);

  @Query("SELECT b FROM Book b JOIN b.author a WHERE a.id = :authorId")
  List<Book> findByAuthor(Long authorId);
  
  @Query("SELECT b FROM Book b JOIN b.category c WHERE c.id = :categoryId")
  List<Book> findByCategory(Long categoryId);

}
