package com.br.ecommercebook.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.ecommercebook.entity.SubCategory;
import org.springframework.stereotype.Repository;
@Repository
public interface SubCategoryRepository extends CrudRepository<SubCategory, Long>{
}
