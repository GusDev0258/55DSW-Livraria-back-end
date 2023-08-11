package com.br.ecommercebook.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.ecommercebook.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
