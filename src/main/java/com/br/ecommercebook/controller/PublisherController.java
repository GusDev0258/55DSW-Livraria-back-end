package com.br.ecommercebook.controller;

import com.br.ecommercebook.vo.PublisherVO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/publisher")
public class PublisherController {

  @PostMapping("/")
  public ResponseEntity<Long> create(@RequestBody PublisherDTO publisherRequest) {
    return ResponseEntity.ok(PublisherVO);
  }

}
