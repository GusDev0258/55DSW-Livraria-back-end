package com.br.ecommercebook.repository;
import org.springframework.data.repository.CrudRepository;

import com.br.ecommercebook.entity.Category;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
