package com.br.ecommercebook.controller;

import com.br.ecommercebook.vo.PublisherVO;
import com.br.ecommercebook.dto.PublisherDTO;
import com.br.ecommercebook.service.PublisherService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("api/publisher")
public class PublisherController {

  private final PublisherService publisherService;

  @PostMapping("/{addressId}")
  public ResponseEntity<PublisherVO> create(@PathVariable Long addressId, @RequestBody PublisherDTO publisherDTO) {
    var PublisherVO = publisherService.create(addressId, publisherDTO);
    return new ResponseEntity<PublisherVO>(PublisherVO, HttpStatus.CREATED);
  }

}
