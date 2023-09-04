package com.bamflix.domain.purchase;

import com.bamflix.domain.cart.CartMapper;
import com.bamflix.domain.content.CartContent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PurchaseService {

    private final PurchaseMapper purchaseMapper;
    private final CartMapper cartMapper;

    public void addPurchase(List<Long> cartIds) {
        for (Long cartId : cartIds) {
            CartContent content = cartMapper.getContentByCartId(cartId);

            PurchaseRequest purchaseRequest = PurchaseRequest.builder()
                .memberId(content.getMemberId())
                .contentId(content.getContentId())
                .build();

            purchaseMapper.addPurchase(purchaseRequest);
        }
    }

    public List<PurchaseResponse> getAllPurchaseById(Long memberId) {
        return purchaseMapper.getAllPurchase(memberId);
    }

    public void deletePurchaseById(Long contentId, Long memberId) {
        purchaseMapper.deletePurchaseById(contentId,memberId);
    }

    public List<Long> checkPurchaseIdByCartId(List<Long> cartIds) {
       return purchaseMapper.checkPurchaseIdByCartId(cartIds);
    }

}
