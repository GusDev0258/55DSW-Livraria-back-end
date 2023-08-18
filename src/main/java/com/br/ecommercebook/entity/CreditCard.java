package com.br.ecommercebook.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "credit_card")
public class CreditCard {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String number;
  private String responsableName;
  private LocalDate expirationDate;
  private String securityCode;

  @ManyToMany(mappedBy="credit_cards")
  private List<User> users;
}
