package com.br.ecommercebook.dto;

import java.time.LocalDate;

import com.br.ecommercebook.enums.BookType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
  private String name;
  private String language;
  private int pagesNumber;
  private String isbn;
  private Double price;
  private String releaseDate;
  private BookType version;
  private Long publisher;
  private Long[] authors;
  private Long[] categories;
}
