package com.br.ecommercebook.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToMany
  @JoinTable(name="cart_book", joinColumns = {@JoinColumn(name="cart_id")}, inverseJoinColumns = {@JoinColumn(name="id")})
  private List<Book> books;

  @OneToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;
  
}
