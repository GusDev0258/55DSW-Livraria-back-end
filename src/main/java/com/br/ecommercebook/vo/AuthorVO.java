package com.br.ecommercebook.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorVO {
  private Long id;
  private String name;
  
  @JsonBackReference
  private List<BookVO> books;
}
