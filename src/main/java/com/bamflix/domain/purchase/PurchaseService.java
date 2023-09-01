package com.bamflix.domain.purchase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PurchaseService {

    private final PurchaseMapper purchaseMapper;

    public void addPurchase(PurchaseRequest params) {
        purchaseMapper.addPurchase(params);
    }

}
