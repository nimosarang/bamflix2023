package com.bamflix.domain.cart;

import com.bamflix.domain.content.CartContentResponse;
import com.bamflix.domain.member.MemberResponse;
import java.util.List;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/addToCart")
    public String addContentInCart(CartRequest cartRequest) {
        cartService.addContent(cartRequest);
        return "redirect:/main";
    }

    @GetMapping("/getFromCart")
    public String getContentsFromCart(Model model, HttpSession session) {
        MemberResponse loginMember = (MemberResponse) session.getAttribute("loginMember");

        if (loginMember == null) {
            return "redirect:/login";
        }

        Long memberId = loginMember.getId();

        List<CartContentResponse> CartContentResponse = cartService.getContentsByMemberId(memberId);

        model.addAttribute("CartContentResponse", CartContentResponse);
        model.addAttribute("loginMember", loginMember);
        return "cart/cartList";
    }

    @PostMapping("/deleteCartContent")
    public String deleteCartContent(@RequestParam Long cartId, @RequestParam Long memberId){
        cartService.deleteContentById(cartId,memberId);
        return "redirect:/getFromCart";
    }

}
