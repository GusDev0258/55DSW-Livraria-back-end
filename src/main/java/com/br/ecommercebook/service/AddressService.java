package com.br.ecommercebook.service;

import org.springframework.stereotype.Service;

import com.br.ecommercebook.repository.AddressRepository;
import com.br.ecommercebook.repository.UserRepository;
import com.br.ecommercebook.dto.AddressDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddressService {

  private final AddressRepository addressRepository;
  private final UserRepository userRepository;

  public Long create(Long userId, AddressDTO addressDTO) {

  }

}
