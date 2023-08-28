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
    private String name;
  private String language;
  private int pagesNumber;
  private String isbn;
  private Double price;
  private LocalDate releaseDate;
  private BookType version;
  private PublisherVO publisher;
  @JsonBackReference
  private List<AuthorVO> author;
  @JsonBackReference
  private List<CategoryVO> category;
}
