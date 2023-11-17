package com.br.ecommercebook.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "category")
public class Category {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    @JsonManagedReference
    private List<SubCategory> subCategory;
    
    @ManyToMany()
    @JoinTable(name="category_book", joinColumns = {@JoinColumn(name="category_id")}, inverseJoinColumns = {@JoinColumn(name="book_id")})
    private List<Book> books;

    @ManyToMany
    @JoinTable(name="category_voucher", joinColumns = {@JoinColumn(name="category_id")}, inverseJoinColumns = {@JoinColumn(name="id")})
    private List<Voucher> voucher;
}
