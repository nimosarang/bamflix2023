package com.bamflix.domain.cart;

import com.bamflix.domain.content.CartContentResponse;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {

    /**
     * 컨텐츠 찜하기
     * @param cartRequest - 컨텐츠 id, 멤버 id
     */
    void insertContent(CartRequest cartRequest);

    /**
     * 멤버 아이디로 해당 멤버가 찜한 컨텐츠 전부 겟또
     * @param memberId - 멤버 id
     * @return - c.id, c.title, c.img_path, c.price, c.delete_yn, f.created_at
     */
    List<CartContentResponse> getContentsByMemberId(Long memberId);

    /**
     * 찜한 컨텐츠 삭제
     * @param contentId - 컨텐츠 아이디
     * @param memberId  - 멤버 아이디
     */
    void deleteContentById(Long contentId, Long memberId);
}
