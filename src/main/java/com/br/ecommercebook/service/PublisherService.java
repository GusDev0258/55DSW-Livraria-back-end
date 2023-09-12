package com.br.ecommercebook.service;

import java.util.List;
import java.util.ArrayList;

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

  private final ModelMapper modelMapper;
  
  public PublisherVO create(PublisherDTO publisherDTO) {
    var publisher = modelMapper.map(publisherDTO, Publisher.class);
    publisherRepository.save(publisher);
    var publisherVO = modelMapper.map(publisher, PublisherVO.class);
    return publisherVO;
  }

  public PublisherVO getPublisherById(Long publisherID){
    var publisher = publisherRepository.findById(publisherID).get();
    var publisherVO = modelMapper.map(publisher, PublisherVO.class);
    return publisherVO;
  }

  public List<PublisherVO> getAll() {
    var publishers = publisherRepository.findAll();
    var publishVOList = new ArrayList<PublisherVO>();
    for(Publisher publisher : publishers){
      var publisherVO = modelMapper.map(publisher, PublisherVO.class);
      publishVOList.add(publisherVO);
    }
    return publishVOList;
  }
}
