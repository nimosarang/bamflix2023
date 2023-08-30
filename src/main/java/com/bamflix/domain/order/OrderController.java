package com.bamflix.domain.order;

import com.bamflix.domain.member.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class OrderController {

    private final OrderService orderService;

//    //메인 페이지
//    @GetMapping("/")
//    public String main(){
//        return "order/main";
//    }

    //구독권 안내 페이지
    @GetMapping("/subscription")
    public String subscription(Model model) {

//        String referer = request.getHeader("referer");
//        request.getSession().setAttribute("subscriptionSession", referer);
//        request.getSession().setMaxInactiveInterval(60 * 30);

        List<SubscriptionResponse> subscriptionList = orderService.getSubscription();

        model.addAttribute("subscriptionList", subscriptionList);

        return "order/subscription";
    }

    //구독권 결제 페이지
    @GetMapping("/order")
    public String orderPage(String from, Model model, HttpSession session, Long id) {
//        request.getParameter("subscriptionPage");

        MemberResponse loginMember = (MemberResponse) session.getAttribute("loginMember");

        if ("subscriptionPage".equals(from)) {
            model.addAttribute("showSubscription", true);
            model.addAttribute("showIndividual", false);

            id = 2L;
            List<SubscriptionResponse> selectList = orderService.selectSubscription(id);
            model.addAttribute("selectList", selectList);
            model.addAttribute("loginMember", loginMember);
//            return "order/order";

        } else if ("individual".equals(from)) {
            model.addAttribute("showIndividual", true);
            model.addAttribute("showSubscription", false);
        }
        return "order/order";
    }

    //카드결제 완료 페이지
    @PostMapping("/order/payment/complete")
    public String paymentComplete(@RequestBody String imp_uid, HttpSession session, OrderInfo orderInfo,
                                  Long totalPrice) throws IOException {

        String token = orderService.getToken();

        System.out.println("토큰 : " + token);

        System.out.println("imp_uid request : " + imp_uid);
        System.out.println("orderInfo.getImpUid : " + orderInfo.getImpUid());

        int amount = orderService.paymentInfo(orderInfo.getImpUid(), token);


        /* 장바구니 및 총액 확인
        CartList cartList = (CartList) session.getAttribute("cartList");
        // 실제 계산 금액 가져오기
        long orderPriceCheck = orderService.orderPriceCheck(cartList)  - usedPoint;

        // 계산 된 금액과 실제 금액이 다를 때
        if (orderPriceCheck != amount) {
            paymentService.payMentCancle(token, orderInfo.getImpUid(), amount, "결제 금액 오류");
            return new ResponseEntity<String>("결제 금액 오류, 결제 취소", HttpStatus.BAD_REQUEST);
        }

        orderService.order(cartList, orderInfo, user);
        session.removeAttribute("cartList");
        
         */

        return "order/payment";
    }

    @GetMapping("/order/payment/complete")
    public String payment() {
        return "order/payment";
    }

}
