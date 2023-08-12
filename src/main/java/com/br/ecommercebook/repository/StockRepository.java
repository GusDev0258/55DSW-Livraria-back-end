package com.br.ecommercebook.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.ecommercebook.entity.Stock;
import org.springframework.stereotype.Repository;
@Repository
public interface StockRepository extends CrudRepository<Stock, Long>{
}