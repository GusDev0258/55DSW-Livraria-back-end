package com.br.ecommercebook.controller;

import com.br.ecommercebook.dto.AddressDTO;
import com.br.ecommercebook.entity.Address;
import com.br.ecommercebook.service.AddressService;
import com.br.ecommercebook.vo.AddressVO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/address")
public class AddressController {

    private AddressService addressService;

    @GetMapping("/user/{userId}")
    public List<AddressVO> getAddressesOfUser(@PathVariable Long userId) {
        return Arrays.asList(new AddressVO());
    }


    @PostMapping("/")
    public ResponseEntity<AddressVO> create(@RequestBody AddressDTO addressDTO){
        var response = addressService.create(addressDTO);
        return new ResponseEntity<AddressVO>(response, HttpStatus.CREATED);
    }


    @GetMapping("/{addressId}")
    public ResponseEntity<AddressVO> getAddress(@PathVariable Long addressId){
        var address = addressService.getAddressById(addressId);
        return new ResponseEntity<AddressVO>(address, HttpStatus.OK);
    }

}
