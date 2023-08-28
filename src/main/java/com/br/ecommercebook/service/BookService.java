package com.br.ecommercebook.service;

import com.br.ecommercebook.dto.BookDTO;
import com.br.ecommercebook.entity.Author;
import com.br.ecommercebook.entity.Book;
import com.br.ecommercebook.entity.Category;
import com.br.ecommercebook.repository.AuthorRepository;
import com.br.ecommercebook.repository.BookRepository;
import com.br.ecommercebook.repository.CategoryRepository;
import com.br.ecommercebook.repository.PublisherRepository;
import com.br.ecommercebook.vo.BookVO;
import lombok.AllArgsConstructor;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class BookService {

  BookRepository bookRepository;
  AuthorRepository authorRepository;
  CategoryRepository categoryRepository;
  PublisherRepository publisherRepository;
  ModelMapper modelMapper;


  public BookVO create(BookDTO bookRequest) {
    var authorArray = bookRequest.getAuthors();
    var authorList = new ArrayList<Author>();
    for(Long authorId : authorArray) {
      var author = authorRepository.findById(authorId).get();
      authorList.add(author);
    }
    var category  = categoryRepository.findById(bookRequest.getCategory()).get();
    var publisher = publisherRepository.findById(bookRequest.getPublisher()).get();
    var book      = modelMapper.map(bookRequest, Book.class);
    var categoryList = new ArrayList<Category>();
    book.setAuthor(authorList);
    book.setCategory(categoryList);
    categoryList.add(category);
    book.setPublisher(publisher);
    bookRepository.save(book);
    return modelMapper.map(book, BookVO.class);
  }

  public BookVO getById(Long id) {
    var book = bookRepository.findById(id);
    return new BookVO();
  }
}
