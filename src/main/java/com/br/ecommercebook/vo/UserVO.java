package com.br.ecommercebook.vo;

import com.br.ecommercebook.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private List<Address> addresses;
}
