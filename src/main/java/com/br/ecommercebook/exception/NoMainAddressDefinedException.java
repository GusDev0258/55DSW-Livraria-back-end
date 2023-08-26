package com.br.ecommercebook.exception;

public class NoMainAddressDefinedException extends RuntimeException{
    public NoMainAddressDefinedException() {
        super("No main address defined.");
    }
}
