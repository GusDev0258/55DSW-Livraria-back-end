package com.br.ecommercebook.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "author")
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  
  @ManyToMany
  @JoinTable(name="author_book", joinColumns = {@JoinColumn(name="author_id")}, inverseJoinColumns = {@JoinColumn(name="book_id")})
  private List<Book> books;
  
}
