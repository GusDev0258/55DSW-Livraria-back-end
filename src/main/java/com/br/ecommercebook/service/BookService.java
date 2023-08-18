package com.br.ecommercebook.service;

import org.springframework.stereotype.Service;

import com.br.ecommercebook.dto.BookDTO;
import com.br.ecommercebook.repository.BookRepository;
import com.br.ecommercebook.vo.response.BookResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class BookService {

  BookRepository bookRepository;

  public Long create(BookDTO bookRequest) {


    return 1L;
  }

  public BookResponse getById(Long id) {
    var book = bookRepository.findById(id);

  }
}
