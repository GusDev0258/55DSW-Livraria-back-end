package com.br.ecommercebook.service;

import com.br.ecommercebook.dto.CategoryDTO;
import com.br.ecommercebook.entity.Category;
import com.br.ecommercebook.entity.SubCategory;
import com.br.ecommercebook.repository.SubCategoryRepository;
import com.br.ecommercebook.vo.SubCategoryVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryService {
    private SubCategoryRepository subCategoryRepository;
//
//    public List<SubCategoryVO> create(CategoryDTO categoryDTO, Category category) {
//        categoryDTO.getSubCategoryDTOList().forEach((subCategoryDTO) -> {
//            category.set
//            subCategoryRepository.save()
//        });
//    }
//
//    private Category updateCategorySubcategory(Long categoryId, SubCategory subCategory) {
//
//    }
}
