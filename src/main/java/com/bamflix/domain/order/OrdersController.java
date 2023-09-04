package com.bamflix.domain.order;

import com.bamflix.domain.content.CartContentResponse;
import com.bamflix.domain.member.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class OrdersController {

    private final OrderService orderService;

    // 구독권 조회 페이지
    @GetMapping("/subscription-page")
    public String getSubscriptionList(Model model){
        List<SubscriptionResponse> subscriptionList = orderService.getSubscription();
        model.addAttribute("subscriptionList", subscriptionList);

        return "/order/subscription";
    }

    //구독권-결제 페이지
    @GetMapping("/order-from-subscription")
    public String orderPage(Model model, HttpSession session){
        MemberResponse loginMember = (MemberResponse) session.getAttribute("loginMember");

            List<SubscriptionResponse> selectList = orderService.getSubscription();
            model.addAttribute("selectList", selectList);
            model.addAttribute("loginMember", loginMember);
            model.addAttribute("userId", loginMember.getLoginId());

        return "/order/order_from_subscription";
    }

    //결제 내역 페이지
    @GetMapping("/order/order_details")
    public String payment(Model model, HttpSession session) {

        MemberResponse loginMember = (MemberResponse) session.getAttribute("loginMember");

        List<SubscriptionResponse> selectList = orderService.getSubscription();
        model.addAttribute("selectList", selectList);
        model.addAttribute("loginMember", loginMember);


        return "order/order_detail";
    }

    //신용카드 결제완료
//    @PostMapping("/order/payment/complete")
//    public String paymentComplete(){
//        System.out.println("결제완료 페이지");
//        return "order/order_detail";
//    }

    //현금 결제완료
    @PostMapping("/order/cash/complete")
    public String cashComplete(@RequestBody Map<String, String> requestData){

        String subscriptionIdStr = requestData.get("subscriptionId");
        String memberIdStr = requestData.get("memberId");

        Long subscriptionId = Long.parseLong(subscriptionIdStr);
        Long memberId = Long.parseLong(memberIdStr);

        System.out.println("현금 결제완료");

        orderService.memberSubscriptionResult(subscriptionId, memberId);

        return "redirect:/order/order_details";
    }

//    카드결제 완료 페이지
    @PostMapping("/order/payment/complete")
    public String paymentComplete(@RequestBody String imp_uid, HttpSession session, OrderInfo orderInfo,
                                  Long totalPrice) throws IOException {

        String token = orderService.getToken();

        System.out.println("토큰 : " + token);

        System.out.println("imp_uid request : " + imp_uid);
        System.out.println("orderInfo.getImpUid : " + orderInfo.getImpUid());

        orderService.paymentInfo(orderInfo.getImpUid(), token);

        return "redirect:/order/order_details";
    }

    //구독권 취소
    @PutMapping("/subscription_cancel/{memberId}")
    @ResponseBody
    public String mySubscriptionCancel(Model model, HttpSession session, @PathVariable Long memberId){

        orderService.MySubscriptionState(memberId);

        return "redirect:/mypage";
    }

}
