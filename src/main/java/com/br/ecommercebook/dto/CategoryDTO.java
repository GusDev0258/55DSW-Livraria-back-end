package com.br.ecommercebook.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryDTO {
    private String name;
    @JsonProperty("subCategories")
    private List<SubCategoryDTO> subCategoryDTOList;

    public List<SubCategoryDTO> getSubCategoryDTOList() {
        if(subCategoryDTOList == null) {
            subCategoryDTOList = new ArrayList<>();
        }
        return subCategoryDTOList;
    }
}
