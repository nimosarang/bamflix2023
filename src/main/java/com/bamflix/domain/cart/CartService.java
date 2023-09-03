package com.bamflix.domain.cart;

import com.bamflix.domain.content.CartContentResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CartService {

    private final CartMapper cartMapper;

    public void addContent(CartRequest cartRequest) {
        cartMapper.insertContent(cartRequest);
    }

    public List<CartContentResponse> getContentsByMemberId(Long memberId) {
        return cartMapper.getContentsByMemberId(memberId);
    }

    public void deleteContentById(Long cartId, Long memberId) {
        cartMapper.deleteContentById(cartId, memberId);
    }

    public Long getCartId(Long memberId) {
      return cartMapper.getCartId(memberId);
    }

}
