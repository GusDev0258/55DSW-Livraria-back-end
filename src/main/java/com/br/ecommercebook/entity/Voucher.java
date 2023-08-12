package com.br.ecommercebook.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "voucher")
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float discount;
    private boolean active;
    @Column(unique = true)
    private int cod;
    @ManyToMany(mappedBy="voucher")
    private List<SubCategory> subCategory;
    private LocalDateTime creationDate;
    private LocalDateTime expiredDate;
}
