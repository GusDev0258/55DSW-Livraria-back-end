package com.br.ecommercebook.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherVO {
  private Long id;
  private String name;
  private String email;
  private String phone;
  
  @JsonBackReference
  private List<BookVO> books;
}
