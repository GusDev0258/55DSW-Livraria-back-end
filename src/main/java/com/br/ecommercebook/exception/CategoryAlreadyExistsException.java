package com.br.ecommercebook.exception;

public class CategoryAlreadyExistsException extends RuntimeException {
    public CategoryAlreadyExistsException  () {
        super("Category already exists");
    }
}
