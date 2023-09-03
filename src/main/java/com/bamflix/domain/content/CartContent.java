package com.bamflix.domain.content;

import java.time.LocalDateTime;
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
public class CartContent {

    private Long id;
    private Long memberId;
    private Long contentId;
    private LocalDateTime createdAt;
    private boolean deleteYn;

}
