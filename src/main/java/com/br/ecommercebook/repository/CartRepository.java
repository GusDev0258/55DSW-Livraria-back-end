package com.br.ecommercebook.repository;

import com.br.ecommercebook.entity.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CartRepository extends CrudRepository<Cart, Long>{
    Cart findCartByUserId(Long userId);
}
