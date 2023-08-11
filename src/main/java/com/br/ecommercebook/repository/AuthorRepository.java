package com.br.ecommercebook.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.ecommercebook.entity.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>{
  
}
