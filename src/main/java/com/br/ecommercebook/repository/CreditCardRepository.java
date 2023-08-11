package com.br.ecommercebook.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.ecommercebook.entity.CreditCard;
import org.springframework.stereotype.Repository;
@Repository

public interface CreditCardRepository extends CrudRepository<CreditCard, Long> {
}
