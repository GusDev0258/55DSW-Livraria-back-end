package com.br.ecommercebook.service;

import com.br.ecommercebook.dto.BookDTO;
import com.br.ecommercebook.entity.Author;
import com.br.ecommercebook.entity.Book;
import com.br.ecommercebook.entity.Category;
import com.br.ecommercebook.repository.AuthorRepository;
import com.br.ecommercebook.repository.BookRepository;
import com.br.ecommercebook.repository.CategoryRepository;
import com.br.ecommercebook.repository.PublisherRepository;
import com.br.ecommercebook.vo.AuthorVO;
import com.br.ecommercebook.vo.BookVO;
import com.br.ecommercebook.vo.CategoryVO;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
    var authors    = this.setAuthorList(bookRequest.getAuthors());
    var categories = this.setCategoryList(bookRequest.getCategories());
    var publisher  = publisherRepository.findById(bookRequest.getPublisher()).get();
    var book       = modelMapper.map(bookRequest, Book.class);
    book.setAuthor(authors);
    book.setCategory(categories);
    book.setPublisher(publisher);
    bookRepository.save(book);
    var authorsVO = this.getAuthorVOList(authors);
    var categoriesVO = this.getCategoryVOList(categories);
    var bookVO = modelMapper.map(book, BookVO.class);
    bookVO.setAuthor(authorsVO);
    bookVO.setCategory(categoriesVO);
    return bookVO;
  }

  public BookVO getById(Long id) {
    var book = bookRepository.findById(id);
    return modelMapper.map(book, BookVO.class);
  }
 
  public BookVO getByName(String name){
    var book = bookRepository.findByName(name);
    return modelMapper.map(book, BookVO.class);
  }

  public List<BookVO> getByAuthor(Long authorId){
    var bookList = bookRepository.findByAuthor(authorId);
    var bookVOList = new ArrayList<BookVO>();
    for(Book book : bookList) {
      var bookVO = modelMapper.map(book, BookVO.class);
      bookVOList.add(bookVO);
    }
    return bookVOList;
  }

  private List<AuthorVO> getAuthorVOList(List<Author> author) {
    var authorVOList = new ArrayList<AuthorVO>();
    for(Author authorItem : author) {
      var authorVO = modelMapper.map(authorItem, AuthorVO.class);
      authorVOList.add(authorVO);
    }
    return authorVOList;
  }

  private List<CategoryVO> getCategoryVOList(List<Category> category) {
    var categoryVOList = new ArrayList<CategoryVO>();
    for(Category categoryItem : category) {
      var categoryVO = modelMapper.map(categoryItem, CategoryVO.class);
      categoryVOList.add(categoryVO);
    }
    return categoryVOList;
  }

  private List<Author> setAuthorList(Long[] Authors){
    var authorList = new ArrayList<Author>();
    for(Long authorId : Authors) {
      var author = authorRepository.findById(authorId).get();
      authorList.add(author);
    }
    return authorList;
  }

  private List<Category> setCategoryList(Long[] Categories){
    var categoryList = new ArrayList<Category>();
    for(Long categoryId : Categories) {
      var category = categoryRepository.findById(categoryId).get();
      categoryList.add(category);
    }
    return categoryList;
  }

}
