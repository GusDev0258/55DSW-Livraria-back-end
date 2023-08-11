package com.br.ecommercebook.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.ecommercebook.entity.PaymentMethod;
import org.springframework.stereotype.Repository;
@Repository
public interface PaymentMethodRepository extends CrudRepository<PaymentMethod, Long>{
}
