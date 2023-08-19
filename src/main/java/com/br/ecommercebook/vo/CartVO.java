package com.br.ecommercebook.vo;

import lombok.Data;
import java.util.List;

@Data
public class CartVO {
    private long id;
    private List<BookVO> books;
}
