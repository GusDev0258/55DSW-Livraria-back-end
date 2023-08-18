package com.br.ecommercebook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherDTO {
  private String name;
  private AddressDTO addressRequest;
}
