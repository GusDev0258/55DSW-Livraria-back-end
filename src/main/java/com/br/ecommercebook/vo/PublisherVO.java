package com.br.ecommercebook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PublisherVO {
  private Long id;
  private String name;
  private AddressVO addressVO;
}
