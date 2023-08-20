package com.br.ecommercebook.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorVO {
  private Long id;
  private String name;
  private List<BookVO> books;
}
