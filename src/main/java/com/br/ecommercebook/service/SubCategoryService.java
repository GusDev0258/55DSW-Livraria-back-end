package com.br.ecommercebook.service;

import com.br.ecommercebook.dto.CategoryDTO;
import com.br.ecommercebook.dto.SubCategoryDTO;
import com.br.ecommercebook.entity.Category;
import com.br.ecommercebook.entity.SubCategory;
import com.br.ecommercebook.exception.CategoryNotFoundException;
import com.br.ecommercebook.repository.SubCategoryRepository;
import com.br.ecommercebook.vo.CategoryVO;
import com.br.ecommercebook.vo.SubCategoryVO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubCategoryService {
    private final SubCategoryRepository subCategoryRepository;
    private final ModelMapper modelMapper;
//
    public List<SubCategory> create(Category categoryEntity, CategoryDTO categoryDTO) {
        var category = modelMapper.map(categoryDTO, Category.class);
        List<SubCategory> subCategories = new ArrayList<>();
        category.getSubCategory().forEach((subCategory -> {
            subCategory.setCategory(categoryEntity);
            subCategories.add(subCategoryRepository.save(subCategory));
        }));
        return subCategories;
    }
//
//    private Category updateSubcategory(Long categoryId, CategoryDTO categoryDTO) {
//
//    }

//    public SubCategoryVO findByName(SubCategoryDTO subCategoryDTO) {
//        var subCategory = subCategoryRepository.findByName(subCategoryDTO.getName());
//        if (subCategory.isEmpty()) {
//            throw new CategoryNotFoundException();
//        }
//        return modelMapper.map(category.get(), CategoryVO.class);
//    }
}
