package com.bamflix.domain.purchase;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping("/purchaseContent")
    public void purchaseContent(@RequestBody List<Long> cartIds) {
        purchaseService.addPurchase(cartIds);
    }

    @GetMapping("/purchaseList")
    public String purchaseList(Model model) {

        return "cart/purchaseList";
    }
}
