package com.bamflix.domain.cart;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CartResponse {

    private Long id;                       // Cart 번호 (PK)
    private Long memberId;
    private Long contentId;
    private LocalDateTime createdDate;     // 생성일시

}
