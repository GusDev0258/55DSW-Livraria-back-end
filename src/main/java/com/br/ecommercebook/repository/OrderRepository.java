package com.br.ecommercebook.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.ecommercebook.entity.Order;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
