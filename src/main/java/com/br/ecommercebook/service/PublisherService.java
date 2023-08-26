package com.br.ecommercebook.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.br.ecommercebook.dto.PublisherDTO;
import com.br.ecommercebook.entity.Publisher;
import com.br.ecommercebook.repository.AddressRepository;
import com.br.ecommercebook.repository.PublisherRepository;
import com.br.ecommercebook.vo.PublisherVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PublisherService {

  private final PublisherRepository publisherRepository;
  private final AddressRepository addressRepository;

  private final ModelMapper modelMapper;
  
  public PublisherVO create(Long addressId, PublisherDTO publisherDTO) {
    var publisher = modelMapper.map(publisherDTO, Publisher.class);
    var address = addressRepository.findById(addressId).get();
    publisher.setAddress(address);
    publisherRepository.save(publisher);
    var publisherVO = modelMapper.map(publisher, PublisherVO.class);
    return publisherVO;
  }

  public PublisherVO getPublisherById(Long publisherID){
    var publisher = publisherRepository.findById(publisherID).get();
    var publisherVO = modelMapper.map(publisher, PublisherVO.class);
    return publisherVO;
  }
}
