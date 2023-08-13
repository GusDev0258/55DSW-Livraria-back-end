package com.br.ecommercebook.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

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
