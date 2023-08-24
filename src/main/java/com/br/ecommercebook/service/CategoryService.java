package com.br.ecommercebook.service;

import com.br.ecommercebook.dto.CategoryDTO;
import com.br.ecommercebook.entity.Category;
import com.br.ecommercebook.exception.CategoryAlreadyExistsException;
import com.br.ecommercebook.exception.CategoryNotFoundException;
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
        if(categoryDTO.getSubCategoryDTOList().isEmpty()) {
            try {
                findByName(categoryDTO);
                throw new CategoryAlreadyExistsException();
            } catch(CategoryNotFoundException e) {
                var category = modelMapper.map(categoryDTO, Category.class);
                categoryRepository.save(category);
                return modelMapper.map(category, CategoryVO.class);
            }
        } else {
            try {
                var oldCategoryDTO = modelMapper.map(findByName(categoryDTO), CategoryDTO.class) ;
                categoryDTO.getSubCategoryDTOList().forEach((subCategoryDTO -> {
                    oldCategoryDTO.getSubCategoryDTOList().add(subCategoryDTO);
                }));
                var category = modelMapper.map(oldCategoryDTO, Category.class);
                categoryRepository.save(category);
                return modelMapper.map(category, CategoryVO.class);

            } catch(CategoryNotFoundException e) {
                var category = modelMapper.map(categoryDTO, Category.class);
                categoryRepository.save(category);
                return modelMapper.map(category, CategoryVO.class);
            }
        }
    }

    public CategoryVO findByName(CategoryDTO categoryDTO) {
        var category = categoryRepository.findByName(categoryDTO.getName());
        if (category.isEmpty()) {
            throw new CategoryNotFoundException();
        }
        return modelMapper.map(category.get(), CategoryVO.class);
    }
}
