package com.br.ecommercebook.repository;

import com.br.ecommercebook.entity.Category;
import com.br.ecommercebook.entity.SubCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubCategoryRepository extends CrudRepository<SubCategory, Long>{
    Optional<SubCategory> findByName(String name);
}
