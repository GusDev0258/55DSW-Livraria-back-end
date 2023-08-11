package com.br.ecommercebook.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.ecommercebook.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
