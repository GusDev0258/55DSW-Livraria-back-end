package com.br.ecommercebook.controller;

import com.br.ecommercebook.dto.CategoryDTO;
import com.br.ecommercebook.exception.CategoryAlreadyExistsException;
import com.br.ecommercebook.service.CategoryService;
import com.br.ecommercebook.service.SubCategoryService;
import com.br.ecommercebook.vo.CategoryVO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/category")
public class CategoryController {
    private CategoryService categoryService;
    private SubCategoryService subCategoryService;

    @PostMapping("/")
    public ResponseEntity<CategoryVO> createAddress(@RequestBody CategoryDTO category) {
        CategoryVO response = categoryService.create(category);

        return new ResponseEntity<CategoryVO>(response, HttpStatus.CREATED);
    }
}
