package com.br.ecommercebook.vo;

import lombok.Data;

import java.util.List;

@Data
public class CategoryVO {
    private Long id;
    private String name;
    private List<SubCategoryVO> subCategoriesVO;
}
