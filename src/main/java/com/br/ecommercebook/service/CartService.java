package com.br.ecommercebook.service;

import com.br.ecommercebook.entity.Cart;
import com.br.ecommercebook.repository.CartRepository;
import com.br.ecommercebook.vo.CartVO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class CartService {

    private final ModelMapper modelMapper;
    private final CartRepository repository;

    public CartVO GetCartByUserId (Long userId){
        var cart = repository.findCartByUserId(userId);
        return modelMapper.map(cart, CartVO.class);
    }


}
