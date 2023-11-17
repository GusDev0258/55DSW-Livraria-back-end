package com.br.ecommercebook.entity;

import com.br.ecommercebook.enums.BookType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String language;
  private int pagesNumber;
  private String isbn;
  private Double price;
  private LocalDate releaseDate;
  private BookType version;
  private String description;
  private String cover;

  @ManyToMany(mappedBy = "books", cascade = CascadeType.REMOVE)
  private List<Author> author;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="publisher_id", nullable=false)
  @JsonBackReference
  private Publisher publisher;

  @ManyToMany(mappedBy = "books", cascade = CascadeType.REMOVE)
  private List<Category> category;

  @ManyToMany(mappedBy = "books", cascade = CascadeType.REMOVE)
  private List<Cart> carts;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="stock_id", nullable=true)
  @JsonBackReference
  private Stock stock;

  @ManyToMany(mappedBy = "books", cascade = CascadeType.REMOVE)
  private List<Order> orders;
}
