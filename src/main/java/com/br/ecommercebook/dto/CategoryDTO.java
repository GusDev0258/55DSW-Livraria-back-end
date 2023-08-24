package com.br.ecommercebook.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryDTO {
    private String name;
    private List<SubCategoryDTO> subCategoryDTOList;
}
