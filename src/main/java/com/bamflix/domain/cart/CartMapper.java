package com.bamflix.domain.cart;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {

    /**
     * 컨텐츠 찜하기
     * @param cartRequest - 컨텐츠 id, 멤버 id
     */
    void insertContent(CartRequest cartRequest);

}
