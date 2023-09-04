package com.bamflix.domain.purchase;

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
public class PurchaseResponse {

    // id들
    private Long purchaseId;
    private Long memberId;
    private Long contentId;
    private Long cartId;
    // content - 제목, 요약, 이미지 이름과 경로
    private String contentTitle;
    private String contentSummary;
    private String contentImgName;
    private String contentImgPath;
    // content - 카테고리, 장르
    private String contentCategory;
    private String contentGenre;
    // content - 가격, 구독 여부
    private Integer contentPrice;
    private Boolean contentIsSubscribeYN;
    // content - 날짜들
    private LocalDateTime contentUploadedAt;
    private LocalDateTime addedToCartAt;
    private LocalDateTime purchaseAt;

}
