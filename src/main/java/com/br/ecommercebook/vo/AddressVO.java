package com.br.ecommercebook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressVO {
    private String city;
    private String cep;
    private int houseNumber;
    private String street;
    private String neighborhood;
    private String state;
}
