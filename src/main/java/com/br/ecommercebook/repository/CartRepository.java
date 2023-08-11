package com.br.ecommercebook.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.ecommercebook.entity.Cart;

public interface CartRepository extends CrudRepository<Cart, Long>{
}
