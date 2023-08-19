package com.br.ecommercebook.controller;

import com.br.ecommercebook.dto.BookDTO;
import com.br.ecommercebook.vo.BookVO;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.br.ecommercebook.dto.BookDTO;

@RestController
@AllArgsConstructor
@RequestMapping("/api/book")
public class BookController {

  @PostMapping("/")
  public ResponseEntity<BookVO> create(@RequestBody BookDTO bookRequest) {
    return ResponseEntity.ok(new BookVO());
  }
}
