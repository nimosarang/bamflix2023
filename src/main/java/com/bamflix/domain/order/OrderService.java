package com.bamflix.domain.order;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderMapper orderMapper;

    //구독권 DB정보 조회
    public List<SubscriptionResponse> getSubscription() {
        return orderMapper.getSubscription();

//        try {
//            // orderMapper.getSubscription() 메서드 호출
//            List<SubscriptionResponse> subscriptionList = orderMapper.getSubscription();
//
//            if (subscriptionList != null && !subscriptionList.isEmpty()) {
//                return subscriptionList;
//            } else {
//                System.out.println("Subscription List is empty or null.");
//                return Collections.emptyList();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            e.getMessage();
//        }
//
//        return Collections.emptyList();
    }

    //선택된 구독권 DB정보 조회
    public List<SubscriptionResponse> selectSubscription(Long id){
        return orderMapper.selectSubscription(id);
    }

//    public List<CartContentResponse> selectIndividual(List<String> cartIds) {
//        System.out.println("서비스단을 못들어오니?");
//        System.out.println("order db : " + orderMapper.getIndividual(cartIds));
//        return orderMapper.getIndividual(cartIds);
//    }

    //결제api Token 가져오기
    @Value("${imp_key}")
    private String impKey;

    @Value("${imp_secret}")
    private String impSecret;

//    public List<SubscriptionResponse> selectSubList() {
//        return orderMapper.selectSubList();
//    }

    public void memberSubscriptionResult(Long subscriptionId, Long memberId) {

        LocalDate today = LocalDate.now();

        OrderRequest orderRequest = OrderRequest.builder()
                        .subscriptionId(subscriptionId)
                                .memberId(memberId)
                                        .startDate(today)
                                                .endDate(today.plusDays(30))
                                                        .state(true).build();

//        request.setSubscriptionId(subscriptionId);
//        request.setMemberID(memberId);
//        request.setStartDate(today);
//        request.setEndDate(today.plusDays(30));
//        request.setState(true);

        orderMapper.insertMemSubResult(orderRequest);
    }

    // 구독권 결제 완료시 히스토리 생성
    public OrderResponse getOrderHistory(Long memberId){
        return orderMapper.selectOrderHistory(memberId);
    }

    public void MySubscriptionState(Long memberId) {
        orderMapper.updateMySubscriptionState(memberId);
    }


    @ToString
    @Getter
    private class Response {
        private PaymentInfo response;
    }

    @ToString
    @Getter
    private class PaymentInfo {
        private int amount;
    }

    public String getToken() throws IOException {
        HttpsURLConnection conn = null;

        URL url = new URL("https://api.iamport.kr/users/getToken");

        conn = (HttpsURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-type", "application/json");
        conn.setRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);
        JsonObject json = new JsonObject();

        json.addProperty("imp_key", impKey);
        json.addProperty("imp_secret", impSecret);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));

        bw.write(json.toString());
        bw.flush();
        bw.close();

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));

        Gson gson = new Gson();

        String response = gson.fromJson(br.readLine(), Map.class).get("response").toString();

        System.out.println(response);

        String token = gson.fromJson(response, Map.class).get("access_token").toString();

        br.close();
        conn.disconnect();

        return token;
    }



    public int paymentInfo(String imp_uid, String access_token) throws IOException{
        HttpsURLConnection conn = null;

        URL url = new URL("https://api.iamport.kr/payments/" + imp_uid);

        conn = (HttpsURLConnection) url.openConnection();

        conn.setRequestMethod("get");
        conn.setRequestProperty("Authorization", access_token);
        conn.setDoOutput(true);

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));

        Gson gson = new Gson();

        Response response = gson.fromJson(br.readLine(), Response.class);

        System.out.println("info : " + response.toString());

        br.close();
        conn.disconnect();

        System.out.println("getResponse : " + response.getResponse());
        return response.getResponse().getAmount();

    }

    public void payMentCancle(String access_token, String imp_uid, String amount, String reason) {


    }


}
