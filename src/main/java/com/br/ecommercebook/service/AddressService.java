package com.br.ecommercebook.service;

import com.br.ecommercebook.repository.AddressRepository;
import com.br.ecommercebook.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {

  private final AddressRepository addressRepository;
  private final UserRepository userRepository;

  public Long create(Long userId, AddressDTO addressRequest) {

  }

}
