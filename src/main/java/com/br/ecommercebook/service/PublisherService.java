package com.br.ecommercebook.service;

import org.springframework.stereotype.Service;

import com.br.ecommercebook.dto.PublisherDTO;
import com.br.ecommercebook.repository.PublisherRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PublisherService {

  private final PublisherRepository publisherRepository;

  
  public Long create(PublisherDTO publisherDTO) {
    var publisher = this.mapper.map(publisherDTO. Publisher.class);
  }

}
