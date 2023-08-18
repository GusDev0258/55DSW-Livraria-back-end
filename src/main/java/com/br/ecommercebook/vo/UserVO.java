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
    private String name;
    private String phone;
    private String userName;
    private String email;
    private LocalDate birthdate;
    private List<Address> addresses;
}
