package com.bamflix.domain.order;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Builder
@ToString
public class PaymentResponse {

    private String imp_uid;

    private String merchant_uid;

    private String pay_method;

    private String card_code;

    private String card_name;

    private String card_number;

    private int card_quota;

    private int card_type;

    private String name;

    private int amount;

    private int cancel_amount;

    private String buyer_name;

    private String buyer_email;

    private String buyer_tel;

    private LocalDate paid_at;

    private LocalDate failed_at;

    private LocalDate cancelled_at;



}
