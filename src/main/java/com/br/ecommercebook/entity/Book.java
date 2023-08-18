package com.br.ecommercebook.entity;

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
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String idiom;
  private int num_pages;
  private String isbn;
  private Double price;
  private LocalDate year;
  private Enum version;

  @ManyToOne
  @JoinColumn(name="author_id", nullable=false)
  @JsonBackReference
  private Author author;

  @ManyToOne
  @JoinColumn(name="publisher_id", nullable=false)
  @JsonBackReference
  private Publisher publisher;

  @ManyToOne
  @JoinColumn(name="sub_category_id", nullable=false)
  @JsonBackReference
  private SubCategory subCategory;

  @ManyToMany(mappedBy = "books")
  private List<Cart> carts;

  @ManyToOne
  @JoinColumn(name="stock_id", nullable=false)
  @JsonBackReference
  private Stock stock;
}
