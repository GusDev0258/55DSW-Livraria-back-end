package com.br.ecommercebook.service;

import com.br.ecommercebook.dto.BookDTO;
import com.br.ecommercebook.repository.BookRepository;
import com.br.ecommercebook.vo.BookVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class BookService {

  BookRepository bookRepository;

  public Long create(BookDTO bookRequest) {


    return 1L;
  }

  public BookVO getById(Long id) {
    var book = bookRepository.findById(id);
    return new BookVO();
  }
}
