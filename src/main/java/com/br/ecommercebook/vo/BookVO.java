package com.br.ecommercebook.vo;

import java.time.LocalDate;
import java.util.List;

import com.br.ecommercebook.enums.BookType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookVO {
  private Long id;
  private String name;
  private String language;
  private int pagesNumber;
  private String isbn;
  private Double price;
  private LocalDate releaseDate;
  private BookType version;
  private PublisherVO publisher;
  private List<AuthorVO> author;
  private List<CategoryVO> category;
}
