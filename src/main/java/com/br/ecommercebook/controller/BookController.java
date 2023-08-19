package com.br.ecommercebook.controller;

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
  public ResponseEntity<Long> create(@RequestBody BookDTO bookRequest) {
    return new ResponseEntity<Long>(1L, HttpStatus.CREATED);
  } 
}
