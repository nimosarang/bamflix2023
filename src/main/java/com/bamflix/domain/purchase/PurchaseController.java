package com.bamflix.domain.purchase;

import com.bamflix.domain.member.MemberResponse;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping("/purchaseContent")
    public void purchaseContent(@RequestBody List<Long> cartIds) {
        purchaseService.addPurchase(cartIds);
    }

    @GetMapping("/purchaseList")
    public String purchaseList(Long memberId, Model model, HttpSession session) {
        List<PurchaseResponse> purchaseList = purchaseService.getAllPurchaseById(memberId);
        model.addAttribute("purchaseList", purchaseList);

        MemberResponse loginMember = (MemberResponse) session.getAttribute("loginMember");
        model.addAttribute("loginMember", loginMember);
        return "cart/purchaseList";
    }

    @PostMapping("/deletePurchaseContent")
    public String deletePurchaseContent(@RequestParam Long contentId, @RequestParam Long memberId){
        purchaseService.deletePurchaseById(contentId,memberId);
        return "redirect:/getFromCart";
    }

    public List<Long> checkPurchaseIdByCartId(List<Long> cartIds) {
        return purchaseService.checkPurchaseIdByCartId(cartIds);
    }

}
