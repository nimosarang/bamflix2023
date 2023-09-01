package com.bamflix.domain.purchase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping("/purchaseContent")
    public String purchaseContent(PurchaseRequest params) {
        purchaseService.addPurchase(params);
        return "redirect:/getFromCart";
    }
}
