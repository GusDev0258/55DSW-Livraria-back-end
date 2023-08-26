package com.br.ecommercebook.exception;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException() {
        super("Category not found");
    }}
