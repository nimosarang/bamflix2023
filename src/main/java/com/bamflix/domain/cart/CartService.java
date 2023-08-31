package com.bamflix.domain.cart;

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
}
