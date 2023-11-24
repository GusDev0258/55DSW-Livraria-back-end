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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    var book = modelMapper.map(bookRequest, Book.class);
    book.setReleaseDate(this.convertStringToDate(bookRequest.getReleaseDate()));
    var authorList = this.setAuthorList(bookRequest.getAuthors(), book);
    var categoryList = this.setCategoryList(bookRequest.getCategories(), book);
    var publisher = publisherRepository.findById(bookRequest.getPublisher()).get();

    book.setAuthor(authorList);
    book.setCategory(categoryList);
    book.setPublisher(publisher);
    bookRepository.save(book);
    var authorVOList = this.getAuthorVOList(authorList);
    var categoryListVO = this.getCategoryVOList(categoryList);
    var bookVO = modelMapper.map(book, BookVO.class);
    bookVO.setAuthor(authorVOList);
    bookVO.setCategory(categoryListVO);
    return bookVO;
  }

  public void delete(Long id) {
    bookRepository.deleteById(id);
  }

  public BookVO update(Long id, BookDTO bookRequest) {
    var book = bookRepository.findById(id).get();
    book.setName(bookRequest.getName());
    book.setLanguage(bookRequest.getLanguage());
    book.setPagesNumber(bookRequest.getPagesNumber());
    book.setIsbn(bookRequest.getIsbn());
    book.setPrice(bookRequest.getPrice());
    book.setReleaseDate(this.convertStringToDate(bookRequest.getReleaseDate()));
    book.setVersion(bookRequest.getVersion());
    var authorList = this.setAuthorList(bookRequest.getAuthors(), book);
    var categoryList = this.setCategoryList(bookRequest.getCategories(), book);
    book.setAuthor(authorList);
    book.setCategory(categoryList);
    book.setPublisher(publisherRepository.findById(bookRequest.getPublisher()).get());
    bookRepository.save(book);
    var authorVOList = this.getAuthorVOList(authorList);
    var categoryListVO = this.getCategoryVOList(categoryList);
    var bookVO = modelMapper.map(book, BookVO.class);
    bookVO.setAuthor(authorVOList);
    bookVO.setCategory(categoryListVO);
    return bookVO;
  }

  public BookVO updatePatch(Long id, Map<String, Object> bookFields) {
    var oldBook = bookRepository.findById(id).get();
    if(oldBook == null) {
      return null;
    }

    modelMapper.map(bookFields, oldBook);
    bookRepository.save(oldBook);
    
    return modelMapper.map(oldBook, BookVO.class);
  } 

  public List<BookVO> getAll() {
    var bookList = bookRepository.findAll();
    var bookVOList = new ArrayList<BookVO>();
    for (Book book : bookList) {
      var bookVO = modelMapper.map(book, BookVO.class);
      bookVOList.add(bookVO);
    }
    return bookVOList;
  }


  public BookVO getById(Long id) {
    var book = bookRepository.findById(id);
    return modelMapper.map(book, BookVO.class);
  }

  public BookVO getByName(String name) {
    var book = bookRepository.findByName(name);
    return modelMapper.map(book, BookVO.class);
  }

  public List<BookVO> getByAuthor(Long authorId) {
    var bookList = bookRepository.findByAuthor(authorId);
    var bookVOList = new ArrayList<BookVO>();
    for (Book book : bookList) {
      var bookVO = modelMapper.map(book, BookVO.class);
      bookVOList.add(bookVO);
    }
    return bookVOList;
  }

  public List<BookVO> getByCategory(Long categoryId) {
    var bookList = bookRepository.findByCategory(categoryId);
    var bookVOList = new ArrayList<BookVO>();
    for (Book book : bookList) {
      var bookVO = modelMapper.map(book, BookVO.class);
      bookVOList.add(bookVO);
    }
    return bookVOList;
  }

  private List<AuthorVO> getAuthorVOList(List<Author> author) {
    var authorVOList = new ArrayList<AuthorVO>();
    for (Author authorItem : author) {
      var authorVO = modelMapper.map(authorItem, AuthorVO.class);
      authorVOList.add(authorVO);
    }
    return authorVOList;
  }

  private List<CategoryVO> getCategoryVOList(List<Category> category) {
    var categoryVOList = new ArrayList<CategoryVO>();
    for (Category categoryItem : category) {
      var categoryVO = modelMapper.map(categoryItem, CategoryVO.class);
      categoryVOList.add(categoryVO);
    }
    return categoryVOList;
  }

  private List<Author> setAuthorList(Long[] Authors, Book book) {
    var authorList = new ArrayList<Author>();
    for (Long authorId : Authors) {
      var author = authorRepository.findById(authorId).get();
      var authorBookList = new ArrayList<Book>();
      authorBookList.add(book);
      author.setBooks(authorBookList);
      authorList.add(author);
    }
    return authorList;
  }

  private List<Category> setCategoryList(Long[] Categories, Book book) {
    var categoryList = new ArrayList<Category>();
    for (Long categoryId : Categories) {
      var category = categoryRepository.findById(categoryId).get();
      var categoryBookList = new ArrayList<Book>();
      categoryBookList.add(book);
      category.setBooks(categoryBookList);
      categoryList.add(category);
    }
    return categoryList;
  }

  private LocalDate convertStringToDate(String date) {
    var dateArray = date.split("/");
    var convertedDate = LocalDate.of(Integer.parseInt(dateArray[2]), Integer.parseInt(dateArray[1]),
        Integer.parseInt(dateArray[0]));
    return convertedDate;
  }
}
