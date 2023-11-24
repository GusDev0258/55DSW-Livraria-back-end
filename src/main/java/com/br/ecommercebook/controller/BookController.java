package com.br.ecommercebook.controller;

import com.br.ecommercebook.dto.BookDTO;
import com.br.ecommercebook.service.BookService;
import com.br.ecommercebook.vo.BookVO;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

  @GetMapping("/{id}")
  public ResponseEntity<BookVO> getById(@PathVariable Long id) {
    var bookResponse = bookService.getById(id);
    return new ResponseEntity<BookVO>(bookResponse, HttpStatus.OK);
  }

  @GetMapping("/")
  public ResponseEntity<BookVO> getByName(@RequestParam String name) {
    var bookResponse = bookService.getByName(name);
    return new ResponseEntity<BookVO>(bookResponse, HttpStatus.OK);
  }

  @GetMapping("/author/{authorId}")
  public ResponseEntity<List<BookVO>> getByAuthor(@PathVariable Long authorId) {
    var bookResponse = bookService.getByAuthor(authorId);
    return new ResponseEntity<List<BookVO>>(bookResponse, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    bookService.delete(id);
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<BookVO> update(@PathVariable Long id, @RequestBody BookDTO bookRequest) {
    var bookResponse = bookService.update(id, bookRequest);
    return new ResponseEntity<BookVO>(bookResponse, HttpStatus.OK);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<BookVO> updatePatch(@PathVariable Long id, @RequestBody Map<String, Object> bookFields) {
    var bookResponse = bookService.updatePatch(id, bookFields );
    return new ResponseEntity<BookVO>(bookResponse, HttpStatus.OK);
  }

  @GetMapping("/category/{categoryId}")
  public ResponseEntity<List<BookVO>> getByCategory(@PathVariable Long categoryId) {
    var bookResponse = bookService.getByCategory(categoryId);
    return new ResponseEntity<List<BookVO>>(bookResponse, HttpStatus.OK);
  }

  @GetMapping("/getAll")
  public ResponseEntity<List<BookVO>> getAll() {
    var bookResponse = bookService.getAll();
    return new ResponseEntity<List<BookVO>>(bookResponse, HttpStatus.OK);
  }
}
