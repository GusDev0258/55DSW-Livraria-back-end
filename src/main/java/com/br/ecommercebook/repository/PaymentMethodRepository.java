package com.br.ecommercebook.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.ecommercebook.entity.PaymentMethod;

public interface PaymentMethodRepository extends CrudRepository<PaymentMethod, Long>{
}
