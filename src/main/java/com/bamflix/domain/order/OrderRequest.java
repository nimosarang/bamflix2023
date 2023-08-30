package com.bamflix.domain.order;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderRequest {

    private Long id;
    private String name;
    private int validityDays;
    private int price;

}
