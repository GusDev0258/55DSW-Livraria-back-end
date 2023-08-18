package com.br.ecommercebook.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/book")
public class BookController {

  @PostMapping("/")
  public ResponseEntity<Long> create(@RequestBody BookDTO bookRequest) {
    return ResponseEntity.ok(BookResponse);
  } 
}
