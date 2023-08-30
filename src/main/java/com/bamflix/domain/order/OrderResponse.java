package com.bamflix.domain.order;

import lombok.Getter;

@Getter
public class OrderResponse {

    private Long id;
    private String name;
    private int validityDays;
    private int price;

}
