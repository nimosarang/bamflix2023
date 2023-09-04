package com.bamflix.domain.content;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CartContentResponse {

    private Long id;
    private Long cartId;
    private String title;
    private String imgPath;
    private Integer price;
    private Boolean deleteYn;
    private LocalDate createdAt;

}
