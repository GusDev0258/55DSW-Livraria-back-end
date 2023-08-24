package com.br.ecommercebook.exception;

public class SubCategoryNotFoundException extends RuntimeException {
    public SubCategoryNotFoundException() {
        super("Subcategory not found");
    }
}
