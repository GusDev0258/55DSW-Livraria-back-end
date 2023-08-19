package com.br.ecommercebook.controller;

import com.br.ecommercebook.dto.PublisherDTO;
import com.br.ecommercebook.service.PublisherService;
import com.br.ecommercebook.vo.PublisherVO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
