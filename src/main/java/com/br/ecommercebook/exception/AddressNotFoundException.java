package com.br.ecommercebook.exception;
public class AddressNotFoundException extends RuntimeException{
    public AddressNotFoundException () {
        super("Address not found.");
    }
}
