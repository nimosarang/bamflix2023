package com.bamflix.domain.cart;

import com.bamflix.domain.member.MemberResponse;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/addToCart")
    public String addContentInCart(@RequestParam Long contentId, @RequestParam Long memberId) {

        CartRequest cartRequest = CartRequest.builder()
            .memberId(memberId)
            .contentId(contentId)
            .build();

        cartService.addContent(cartRequest);
        return "redirect:/main";
    }


}
