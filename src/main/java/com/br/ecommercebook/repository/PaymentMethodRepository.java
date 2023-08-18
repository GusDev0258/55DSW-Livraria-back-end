package com.br.ecommercebook.repository;

import com.br.ecommercebook.entity.PaymentMethod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PaymentMethodRepository extends CrudRepository<PaymentMethod, Long>{
}
