package com.bamflix.domain.cart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CartRequest {

    private Long id;                       // Cart 번호 (PK)
    private Long memberId;
    private Long contentId;

}
