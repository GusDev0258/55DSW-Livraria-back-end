package com.br.ecommercebook.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.ecommercebook.entity.WishList;
import org.springframework.stereotype.Repository;
@Repository
public interface WishListRepository extends CrudRepository<WishList, Long>{
}
