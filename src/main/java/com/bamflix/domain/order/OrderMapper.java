package com.bamflix.domain.order;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<SubscriptionResponse> getSubscription();

    List<SubscriptionResponse> selectSubscription(Long id);


}
