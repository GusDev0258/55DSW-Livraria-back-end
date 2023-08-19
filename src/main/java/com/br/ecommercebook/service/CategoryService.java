package com.br.ecommercebook.service;

import com.br.ecommercebook.dto.CategoryDTO;
import com.br.ecommercebook.entity.Category;
import com.br.ecommercebook.repository.CategoryRepository;
import com.br.ecommercebook.vo.CategoryVO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;

    public CategoryVO create(CategoryDTO categoryDTO) {
        var category = modelMapper.map(categoryDTO, Category.class);
        categoryRepository.save(category);
        return modelMapper.map(category, CategoryVO.class);
    }
}
