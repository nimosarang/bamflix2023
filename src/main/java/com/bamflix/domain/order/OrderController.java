//package com.bamflix.domain.order;
//
//import com.bamflix.domain.content.CartContentResponse;
//import com.bamflix.domain.content.ContentResponse;
//import com.bamflix.domain.member.MemberResponse;
//import com.siot.IamportRestClient.IamportClient;
//import com.siot.IamportRestClient.exception.IamportResponseException;
//import com.siot.IamportRestClient.response.IamportResponse;
//import com.siot.IamportRestClient.response.Payment;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.List;
//
//@RequiredArgsConstructor
//@RestController
//public class OrderController {
//
//    private final OrderService orderService;
//
//
////    //메인 페이지
////    @GetMapping("/")
////    public String main(){
////        return "order/main";
////    }
//
//    //구독권 안내 페이지
//    @GetMapping("/subscription")
//    public String subscription(Model model) {
//
////        String referer = request.getHeader("referer");
////        request.getSession().setAttribute("subscriptionSession", referer);
////        request.getSession().setMaxInactiveInterval(60 * 30);
//        System.out.println("여기 왜?");
//        List<SubscriptionResponse> subscriptionList = orderService.getSubscription();
//
//        if(subscriptionList != null && !subscriptionList.equals("")){
//            System.out.println("subscriptionList : null 아님");
//            model.addAttribute("subscriptionList", subscriptionList);
//        }else{
//            System.out.println("subscriptionList : null임");
//        }
//
//
//        return "order/subscription";
//    }
//
////    @GetMapping("/sub-list")
////    @ResponseBody
////    public String subList (Model model) {
////        List<SubscriptionResponse> subList = orderService.selectSubList();
////        model.addAttribute("subList", subList);
////
////        return "order/sub_list";
////    }
//
//    //구독권 결제 페이지
////    @GetMapping("/order")
////    public String orderPage(String from, Model model, HttpSession session, Long id, @RequestParam(value = "cartIds") List<String> cartIds) {
////
////        MemberResponse loginMember = (MemberResponse) session.getAttribute("loginMember");
////
////        if ("subscriptionPage".equals(from)) {
////            model.addAttribute("showSubscription", true);
////            model.addAttribute("showIndividual", false);
////
////            id = 2L;
////            List<SubscriptionResponse> selectList = orderService.selectSubscription(id);
////            model.addAttribute("selectList", selectList);
////            model.addAttribute("loginMember", loginMember);
////            model.addAttribute("userId", loginMember.getLoginId());
////
////        } else if ("individualPage".equals(from)) {
////            model.addAttribute("showIndividual", true);
////            model.addAttribute("showSubscription", false);
////
////            System.out.println(cartIds);
////
////            String cart_id = "";
////            for(int i = 0; i < cartIds.size(); i++){
////                if(i != cartIds.size()-1){
////                    cart_id += cartIds.get(i) + ",";
////                }else if( i == cartIds.size()-1){
////                    cart_id += cartIds.get(i);
////                }
////            }
////
////            System.out.println("cart_id String : " + cart_id);
////
////            List<CartContentResponse> selectList = orderService.selectIndividual(cartIds);
////            model.addAttribute("selectList", selectList);
////        }
////
////        return "order/order";
////    }
//
//    private IamportClient api;
//    public OrderController(){
//        this.api = new IamportClient("4520250004187701", "0wjPcGiOhybJUo4CAaocWyyavMOJcOZhxDlkFsj9Gbw2mbuRCoXmlPeQwJYMXnocqAuUKFk4uDk2MtYV");
//        orderService = null;
//    }
//    @PostMapping("/order/payment/{imp_uid}")
//    public IamportResponse<Payment> paymentComplete(@PathVariable(value = "imp_uid") String imp_uid, String userId) throws IamportResponseException, IOException {
//
//        System.out.println("여기 검증");
//        System.out.println("api : " + api.paymentByImpUid(imp_uid));
//        return api.paymentByImpUid(imp_uid);
//
//    }
//
////    카드결제 완료 페이지
////    @PostMapping("/order/payment/complete")
////    public PaymentResponse paymentComplete(@RequestBody String imp_uid, HttpSession session, OrderInfo orderInfo,
////                                  Long totalPrice) throws IOException {
////
////        String token = orderService.getToken();
////
////        System.out.println("토큰 : " + token);
////
////        System.out.println("imp_uid request : " + imp_uid);
////        System.out.println("orderInfo.getImpUid : " + orderInfo.getImpUid());
////
////        int amount = orderService.paymentInfo(orderInfo.getImpUid(), token);
////
////
////        if(amount != 0) {
////            return null;
////        }else {
////            return null;
////        }
////
////        /* 장바구니 및 총액 확인
////        CartList cartList = (CartList) session.getAttribute("cartList");
////        // 실제 계산 금액 가져오기
////        long orderPriceCheck = orderService.orderPriceCheck(cartList)  - usedPoint;
////
////        // 계산 된 금액과 실제 금액이 다를 때
////        if (orderPriceCheck != amount) {
////            paymentService.payMentCancle(token, orderInfo.getImpUid(), amount, "결제 금액 오류");
////            return new ResponseEntity<String>("결제 금액 오류, 결제 취소", HttpStatus.BAD_REQUEST);
////        }
////
////        orderService.order(cartList, orderInfo, user);
////        session.removeAttribute("cartList");
////
////         */
////
//////        return "order/order_detail";
////    }
//
////    @GetMapping("/order/order_detail")
////    public String payment(Model model, HttpSession session, Long id) {
////
////        MemberResponse loginMember = (MemberResponse) session.getAttribute("loginMember");
////
////            id = 2L;
////            List<SubscriptionResponse> selectList = orderService.selectSubscription(id);
////            model.addAttribute("selectList", selectList);
////            model.addAttribute("loginMember", loginMember);
////
////        return "order/order_detail";
////    }
//
//    @GetMapping("/my_cart")
//    public String myCart(){
//        return "/order/my_cart";
//    }
//
//
//}
