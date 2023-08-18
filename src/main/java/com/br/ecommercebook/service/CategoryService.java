package com.br.ecommercebook.service;

import com.br.ecommercebook.entity.Category;
import com.br.ecommercebook.vo.CategoryVO;
import com.br.ecommercebook.repository.CategoryRepository;
import com.br.ecommercebook.vo.CategoryVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryVO createCategory(String name) {
        var category = new Category();
        category.setName(name);
        categoryRepository.save(category);
    }
}
