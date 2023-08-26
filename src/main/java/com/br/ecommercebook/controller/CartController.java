package com.br.ecommercebook.controller;

import com.br.ecommercebook.service.CartService;
import com.br.ecommercebook.vo.CartVO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/cart")
public class CartController {

    private CartService service;
    @GetMapping("/{userId}")
    public ResponseEntity<CartVO> getUserCart(@PathVariable Long userId){
        var response = service.GetCartByUserId(userId);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
