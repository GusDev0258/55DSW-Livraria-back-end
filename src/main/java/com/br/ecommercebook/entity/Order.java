package com.br.ecommercebook.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "order")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime dateTimeOrder;
  
  private Double price;

  private String trackingCode;

  private String status;

  @ManyToMany()
  @JoinTable(name="order_book", joinColumns = {@JoinColumn(name="order_id")}, inverseJoinColumns = {@JoinColumn(name="id")})
  private List<Book> books;

  @OneToOne()
  @JoinColumn(name = "payment_method_id", nullable = false, referencedColumnName = "id")
  private PaymentMethod paymentMethod;

}
