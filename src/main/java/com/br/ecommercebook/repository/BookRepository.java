package com.br.ecommercebook.repository;

import com.br.ecommercebook.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
