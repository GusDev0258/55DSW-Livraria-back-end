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
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  @ManyToMany
  @JoinTable(name="author_boook", joinColumns = {@JoinColumn(name="author_id")}, inverseJoinColumns = {@JoinColumn(name="id")})
  private List<Book> books;
}
