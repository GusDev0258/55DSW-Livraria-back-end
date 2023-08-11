package com.br.ecommercebook.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.ecommercebook.entity.Stock;

public interface StockRepository extends CrudRepository<Stock, Long>{
}
