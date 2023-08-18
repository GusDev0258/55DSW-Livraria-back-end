package com.br.ecommercebook.repository;

import com.br.ecommercebook.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findAllByName(String name);
}
