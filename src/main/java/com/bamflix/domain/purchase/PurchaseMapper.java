package com.bamflix.domain.purchase;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PurchaseMapper {

    /**
     * 컨텐츠 구매
     * @param params - memberId, contentId
     */
    void addPurchase(PurchaseRequest params);

}
