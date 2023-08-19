package com.br.ecommercebook.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private Long id;
    private String name;
    private String phone;
    private String userName;
    private String email;
    private String password;
    private LocalDate birthdate;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    @Column(name = "addresses")
    @JsonManagedReference
    private List<Address> addresses;
    @OneToMany(cascade = CascadeType.REMOVE)
    @Column(name = "tokens")
    @JsonManagedReference
    private List<Token> tokens;

    @ManyToMany
    @JoinTable(name="user_credit_card", joinColumns = {@JoinColumn(name="user_id")}, inverseJoinColumns = {@JoinColumn(name="id")})
    private List<CreditCard> creditCards;
}
