package com.br.ecommercebook.service;

import com.br.ecommercebook.dto.AddressDTO;
import com.br.ecommercebook.repository.AddressRepository;
import com.br.ecommercebook.repository.UserRepository;
import com.br.ecommercebook.vo.AddressVO;
import com.br.ecommercebook.dto.AddressDTO;
import com.br.ecommercebook.entity.Address;

import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {

  private final AddressRepository addressRepository;
  private final UserRepository userRepository;
  private final ModelMapper modelMapper;

<<<<<<< HEAD
  public Address create(Long userId, AddressDTO addressDTO) {
    var address = new Address();
    return address;
  }

  public AddressVO create(AddressDTO addressDTO) {
    var address = modelMapper.map(addressDTO, Address.class);
    var addressEntity = addressRepository.save(address);
    return modelMapper.map(addressEntity, AddressVO.class);
=======
  public Long create(Long userId, AddressDTO addressRequest) {
    return 1L;
>>>>>>> a06ff44f670166994aea2f442d803a651024bf50
  }

}
