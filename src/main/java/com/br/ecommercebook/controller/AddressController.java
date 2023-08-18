package com.br.ecommercebook.controller;
import com.br.ecommercebook.dto.AddressDTO;
import com.br.ecommercebook.entity.Address;
import com.br.ecommercebook.service.AddressService;
import com.br.ecommercebook.vo.AddressVO;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/address")
public class AddressController {



    private AddressService addressService;

    @GetMapping("/user/{userId}")
    public List<Address> getAddressesOfUser(@PathVariable Long userId) {
        return addressService.getAddressByUserId(userId);
    }


    @PostMapping("/user/{id}")
    public ResponseEntity<Long> createAddress(@PathVariable Long id, @RequestBody AddressDTO address){
        Long response = addressService.create(id, address);
        return new ResponseEntity<Long>(response, HttpStatus.CREATED);
    }

    @PutMapping("{id}/user/{userId}")
    public ResponseEntity<AddressVO> updateAddressesOfUser(@PathVariable Long userId, @PathVariable Long id, @RequestBody AddressDTO address) {
        addressService.update(userId, id, address);
        return new ResponseEntity(address, HttpStatus.OK);
    }

    @DeleteMapping("{id}/user/{userId}")
    public ResponseEntity<AddressVO> deleteAddressesOfUser(@PathVariable Long userId, @PathVariable Long id) {
        addressService.delete(userId, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/main")
    public Address getMainAddress(@PathVariable Long userId){
        return addressService.getMainAddress(userId);
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<Address> getAddress(@PathVariable Long addressId){
        var RequestedAddress = addressService.getAddressById(addressId);
        return new ResponseEntity<>(RequestedAddress, HttpStatus.OK);
    }

}
