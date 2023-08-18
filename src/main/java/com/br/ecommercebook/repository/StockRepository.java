package com.br.ecommercebook.repository;

import com.br.ecommercebook.entity.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StockRepository extends CrudRepository<Stock, Long>{
}
