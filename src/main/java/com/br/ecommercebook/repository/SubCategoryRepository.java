package com.br.ecommercebook.repository;

import com.br.ecommercebook.entity.SubCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SubCategoryRepository extends CrudRepository<SubCategory, Long>{
}
