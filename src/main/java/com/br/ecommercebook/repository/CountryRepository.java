package com.br.ecommercebook.repository;

import com.br.ecommercebook.entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CountryRepository extends CrudRepository<Country, Long>{
}
