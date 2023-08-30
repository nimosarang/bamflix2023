package com.bamflix.domain.order;

import lombok.Getter;

@Getter
public class SubscriptionResponse {

    private Long id;
    private String name;
    private int validityDays;
    private int price;

}
