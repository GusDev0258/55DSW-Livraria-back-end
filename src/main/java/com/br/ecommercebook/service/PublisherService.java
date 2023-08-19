package com.br.ecommercebook.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.br.ecommercebook.dto.PublisherDTO;
import com.br.ecommercebook.entity.Publisher;
import com.br.ecommercebook.repository.PublisherRepository;
import com.br.ecommercebook.vo.PublisherVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PublisherService {

  private final PublisherRepository publisherRepository;

  private final ModelMapper modelMapper;
  
  public PublisherVO create(PublisherDTO publisherDTO) {
    var publisher = modelMapper.map(publisherDTO, Publisher.class);
    var publisherEntity = publisherRepository.save(publisher);
    var publisherVO = modelMapper.map(publisherEntity, PublisherVO.class);
    return publisherVO;
  }

}
