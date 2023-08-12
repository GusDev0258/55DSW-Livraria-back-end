package com.br.ecommercebook.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.br.ecommercebook.entity.Author;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

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

  @ManyToOne
  @JoinColumn(name="stock_id", nullable=false)
  @JsonBackReference
  private Stock stock;
}
