package com.br.ecommercebook.controller;

import com.br.ecommercebook.dto.BookDTO;
import com.br.ecommercebook.service.BookService;
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

  private BookService bookService;

  @PostMapping("/")
  public ResponseEntity<BookVO> create(@RequestBody BookDTO bookRequest) {
    var bookResponse = bookService.create(bookRequest);
    return new ResponseEntity<BookVO>(bookResponse, HttpStatus.CREATED);
  }
}
//TODO: 1.1  -  Crie um endpoint para salvar um livro
//TODO: 1.2  -  Crie um endpoint para listar todos os livros
//TODO: 1.3  -  Crie um endpoint para buscar um livro por id
//TODO: 1.4  -  Crie um endpoint para atualizar um livro
//TODO: 1.5  -  Crie um endpoint para deletar um livro
//TODO: 1.6  -  Crie um endpoint para buscar um livro por nome
//TODO: 1.7  -  Crie um endpoint para buscar um livro por autor
//TODO: 1.8  -  Crie um endpoint para buscar um livro por editora
//TODO: 1.9  -  Crie um endpoint para buscar um livro por ano de publicação
//TODO: 1.10 -  Crie um endpoint para buscar um livro por categoria
//TODO: 1.11 -  Crie um endpoint para buscar um livro por preço
//TODO: 1.12 -  Crie um endpoint para buscar um livro por ISBN
//TODO: 1.13 -  Crie um endpoint para buscar um livro por idioma