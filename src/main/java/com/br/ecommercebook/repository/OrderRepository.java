package com.br.ecommercebook.repository;

import com.br.ecommercebook.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
