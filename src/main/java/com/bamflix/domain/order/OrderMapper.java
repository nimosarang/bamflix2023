package com.bamflix.domain.order;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<SubscriptionResponse> getSubscription();

    List<SubscriptionResponse> selectSubscription(Long id);

//    List<ContentResponse> selectMycart();

//    List<CartContentResponse> getIndividual(List<String> cartIds);

//    List<SubscriptionResponse> selectSubList();

    void insertMemSubResult(OrderRequest request);
}
