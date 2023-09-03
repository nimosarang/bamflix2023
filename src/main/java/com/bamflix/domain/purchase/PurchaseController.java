package com.bamflix.domain.purchase;

import com.bamflix.domain.cart.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping("/purchaseContent")
    public String purchaseContent(Long cartId) {
        purchaseService.addPurchase(cartId);
        return "redirect:/getFromCart";
    }

}
