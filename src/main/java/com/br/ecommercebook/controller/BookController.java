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
    try {
      var bookResponse = bookService.create(bookRequest);
      return new ResponseEntity<BookVO>(bookResponse, HttpStatus.CREATED);
    } catch (Exception error) {
      return new ResponseEntity<BookVO>(HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<BookVO> getById(@PathVariable Long id) {
    try {
      var bookResponse = bookService.getById(id);
      return new ResponseEntity<BookVO>(bookResponse, HttpStatus.OK);
    } catch(Exception error) {
      return new ResponseEntity<BookVO>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/")
  public ResponseEntity<BookVO> getByName(@RequestParam String name) {
    try {
      var bookResponse = bookService.getByName(name);
      return new ResponseEntity<BookVO>(bookResponse, HttpStatus.OK);
    } catch(Exception error) {
      return new ResponseEntity<BookVO>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/author/{authorId}")
  public ResponseEntity<List<BookVO>> getByAuthor(@PathVariable Long authorId) {
    try {
      var bookResponse = bookService.getByAuthor(authorId);
      return new ResponseEntity<List<BookVO>>(bookResponse, HttpStatus.OK);
    } catch(Exception error) {
      return new ResponseEntity<List<BookVO>>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    try {
      bookService.delete(id);
      return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    } catch (Exception error) {
      return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<BookVO> update(@PathVariable Long id, @RequestBody BookDTO bookRequest) {
    try {
      var bookResponse = bookService.update(id, bookRequest);
      return new ResponseEntity<BookVO>(bookResponse, HttpStatus.OK);
    } catch (Exception error) {
      return new ResponseEntity<BookVO>(HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }

  @PatchMapping("/{id}")
  public ResponseEntity<BookVO> updatePatch(@PathVariable Long id, @RequestBody Map<String, Object> bookFields) {
    try {
      var bookResponse = bookService.updatePatch(id, bookFields );
      return new ResponseEntity<BookVO>(bookResponse, HttpStatus.OK);
    } catch (Exception error) {
      return new ResponseEntity<BookVO>(HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }

  @GetMapping("/category/{categoryId}")
  public ResponseEntity<List<BookVO>> getByCategory(@PathVariable Long categoryId) {
    try {
      var bookResponse = bookService.getByCategory(categoryId);
      return new ResponseEntity<List<BookVO>>(bookResponse, HttpStatus.OK);
    } catch (Exception error) {
      return new ResponseEntity<List<BookVO>>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/getAll")
  public ResponseEntity<List<BookVO>> getAll() {
    try {
      var bookResponse = bookService.getAll();
      return new ResponseEntity<List<BookVO>>(bookResponse, HttpStatus.OK);
    } catch (Exception error) {
      return new ResponseEntity<List<BookVO>>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
