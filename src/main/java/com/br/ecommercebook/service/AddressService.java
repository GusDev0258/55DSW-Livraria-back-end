package com.br.ecommercebook.service;

import com.br.ecommercebook.dto.AddressDTO;
import com.br.ecommercebook.exception.AddressNotFoundException;
import com.br.ecommercebook.exception.NoMainAddressDefinedException;
import com.br.ecommercebook.exception.UserNotFoundException;
import com.br.ecommercebook.repository.AddressRepository;
import com.br.ecommercebook.vo.AddressVO;
import com.br.ecommercebook.entity.Address;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AddressService {

  private final AddressRepository addressRepository;
  private final ModelMapper modelMapper;

  public AddressVO getAddressById(Long addressId){
    var response = addressRepository.findById(addressId)
            .orElseThrow(AddressNotFoundException::new);

    return modelMapper.map(response, AddressVO.class);
  }

  public List<AddressVO> getAddressByUserId(Long userId){
    var addresses = addressRepository.findByUserId(userId)
            .orElseThrow(UserNotFoundException::new);

    var response = new ArrayList<AddressVO>();
    addresses.forEach(a -> response.add(modelMapper.map(a, AddressVO.class)));

    return response;
  }

  public AddressVO create(AddressDTO addressDTO) {
    var address = modelMapper.map(addressDTO, Address.class);
    var addressEntity = addressRepository.save(address);

    return modelMapper.map(addressEntity, AddressVO.class);
  }

  public AddressVO getMainAddress(Long userId){
    var addresses = addressRepository.findByUserId(userId).orElseThrow(UserNotFoundException::new);
    var address = addresses
            .stream()
            .filter(Address::isMainAddress)
            .findFirst()
            .orElseThrow(NoMainAddressDefinedException::new);

    return modelMapper.map(address, AddressVO.class);
  }

  public AddressVO update(Long addressId, AddressDTO request){
    var address = addressRepository.findById(addressId)
            .orElseThrow(AddressNotFoundException::new);

    return updateEntity(address, request);
  }

  public void delete(Long addressId){
    var address = addressRepository.findById(addressId)
            .orElseThrow(AddressNotFoundException::new);
    addressRepository.delete(address);
  }

  private AddressVO updateEntity(Address oldObj, AddressDTO newObj){
    oldObj.setCity(newObj.getCity());
    oldObj.setCep(newObj.getCep());
    oldObj.setHouseNumber(newObj.getHouseNumber());
    oldObj.setStreet(newObj.getStreet());
    oldObj.setNeighborhood(newObj.getNeighborhood());
    oldObj.setState(newObj.getState());
    oldObj.setCountry(newObj.getCountry());
    oldObj.setComplement(newObj.getComplement());
    oldObj.setMainAddress(newObj.isMain_address());

    return modelMapper.map(oldObj, AddressVO.class);
  }
}