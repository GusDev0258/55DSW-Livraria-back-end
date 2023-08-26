package com.br.ecommercebook.service;

import com.br.ecommercebook.dto.CategoryDTO;
import com.br.ecommercebook.entity.Category;
import com.br.ecommercebook.entity.SubCategory;
import com.br.ecommercebook.exception.CategoryAlreadyExistsException;
import com.br.ecommercebook.exception.CategoryNotFoundException;
import com.br.ecommercebook.repository.CategoryRepository;
import com.br.ecommercebook.vo.CategoryVO;
import com.br.ecommercebook.vo.SubCategoryVO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;
    private SubCategoryService subCategoryService;

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
                category.setSubCategory(new ArrayList<>());
                var categoryEntity = categoryRepository.save(category);
                var subCategories = subCategoryService.create(categoryEntity, categoryDTO);
                categoryEntity.setSubCategory(subCategories);
                categoryRepository.save(categoryEntity);
                var categoryVO = findByName(categoryDTO);
                categoryVO.setSubCategoriesVO(subCategories.stream().map((subCategory -> modelMapper.map(subCategory, SubCategoryVO.class))).collect(Collectors.toList()));
                return categoryVO;
            }
        }
    }

    public CategoryVO findByName(CategoryDTO categoryDTO) {
        var category = categoryRepository.findByName(categoryDTO.getName());
        if (category.isEmpty()) {
            throw new CategoryNotFoundException();
        }
        var a = category.get();
        return modelMapper.map(category.get(), CategoryVO.class);
    }
}
