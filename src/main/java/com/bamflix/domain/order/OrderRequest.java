package com.bamflix.domain.order;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class OrderRequest {

    private Long id;
    private Long subscriptionId;
    private Long memberId;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean state;

}
