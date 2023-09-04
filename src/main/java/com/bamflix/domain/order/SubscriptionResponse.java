package com.bamflix.domain.order;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class SubscriptionResponse {

    private Long id;
    private String name;
    private int validityDays;
    private int price;

}
