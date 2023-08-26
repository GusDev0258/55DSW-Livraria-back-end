package com.br.ecommercebook.controller;

import com.br.ecommercebook.dto.AddressDTO;
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
    public ResponseEntity<List<AddressVO>> getAddressesOfUser(@PathVariable Long userId) {
        var response = addressService.getAddressByUserId(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<AddressVO> create(@RequestBody AddressDTO addressDTO){
        var response = addressService.create(addressDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
   public ResponseEntity<AddressVO> updateAddress(@PathVariable Long id, @RequestBody AddressDTO address) {
        var response = addressService.update(id, address);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/user/{userId}/main")
    public ResponseEntity<AddressVO> getMainAddress(@PathVariable Long userId){
        var response = addressService.getMainAddress(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<AddressVO> getAddress(@PathVariable Long addressId) {
        var response = addressService.getAddressById(addressId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}