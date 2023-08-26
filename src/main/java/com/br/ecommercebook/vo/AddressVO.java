package com.br.ecommercebook.vo;

import com.br.ecommercebook.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressVO {
    private Long id;
    private String city;
    private String cep;
    private int houseNumber;
    private String street;
    private String neighborhood;
    private String state;
    private String country;
    private String complement;

    public AddressVO(List<Address> addresses) {
    }
}
