package com.br.ecommercebook.entity;

import com.br.ecommercebook.enums.BookType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

  @ManyToMany(mappedBy = "books")
  private List<Author> author;

  @ManyToOne
  @JoinColumn(name="publisher_id", nullable=false)
  @JsonBackReference
  private Publisher publisher;

  @ManyToMany(mappedBy = "books")
  private List<Category> category;

  @ManyToMany(mappedBy = "books")
  private List<Cart> carts;

  @ManyToOne
  @JoinColumn(name="stock_id", nullable=true)
  @JsonBackReference
  private Stock stock;

  @ManyToMany(mappedBy = "books")
  private List<Order> orders;
}
