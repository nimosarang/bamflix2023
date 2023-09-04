package com.bamflix.domain.purchase;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PurchaseMapper {

    /**
     * 컨텐츠 구매
     * @param params - memberId, contentId
     */
    void addPurchase(PurchaseRequest params);

    /**
     * 컨텐츠 구매 내역
     * @param memberId - 멤버 아이디
     * @return - 컨텐츠 구매 내역 (뷰 테이블)
     */
    List<PurchaseResponse> getAllPurchase(Long memberId);

    /**
     * purchaseId 중복 체크
     * @param cartIds - cart id
     * @return - 컨텐츠 id
     */
    List<Long> checkPurchaseIdByCartId(List<Long> cartIds);

    /**
     * 구매 하려는 목록에서 삭제
     * @param contentId - 컨텐츠 아이디
     * @param memberId - 멤버 아이디
     */
    void deletePurchaseById(Long contentId, Long memberId);
}
