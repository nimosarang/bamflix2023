package com.bamflix.domain.order;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class OrderResponse {

    private Long id;
    private Long subscriptionId;
    private Long memberID;
    private String subscriptionName;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean state;

}
