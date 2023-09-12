package com.br.ecommercebook.controller;

import com.br.ecommercebook.dto.PublisherDTO;
import com.br.ecommercebook.service.PublisherService;
import com.br.ecommercebook.vo.PublisherVO;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/publisher")
public class PublisherController {

    private final PublisherService publisherService;

  @PostMapping("/")
  public ResponseEntity<PublisherVO> create(@RequestBody PublisherDTO publisherDTO) {
    var PublisherVO = publisherService.create(publisherDTO);
    return new ResponseEntity<PublisherVO>(PublisherVO, HttpStatus.CREATED);
  }

  @GetMapping("/{publisherId}")
  public ResponseEntity<PublisherVO> getPublisher(@PathVariable Long publisherId) {
    var publisher = publisherService.getPublisherById(publisherId);
    return new ResponseEntity<PublisherVO>(publisher, HttpStatus.OK);
  }

  @GetMapping("/getAll")
  public ResponseEntity<List<PublisherVO>> getAll(){
    var publishers = publisherService.getAll();
    return new ResponseEntity<List<PublisherVO>>(publishers, HttpStatus.OK);
  }

}
