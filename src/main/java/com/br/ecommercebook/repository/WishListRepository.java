package com.br.ecommercebook.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface WishListRepository extends CrudRepository<WishList, Long>{
}
