package com.br.ecommercebook.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String city;
    private String cep;
    private int houseNumber;
    private String street;
    private String neighborhood;
    private String state;
    private String country;
    @Column(nullable = true)
    private String complement;

    @Column(name = "main_address", nullable = false)
    private boolean mainAddress;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    @OneToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
    }

