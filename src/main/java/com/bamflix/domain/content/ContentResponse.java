package com.bamflix.domain.content;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ContentResponse {
    private Long id;
    private String title;
    private String summary;
    private String videoUrl;
    private String originalUrl;
    private String thumbUrl;
    private LocalDateTime uploadedAt;
    private String createCountry;
    private String createYear;
    private Integer isSubscribeYn;
    private String director;
    private Integer price;
    private Integer deleteYn;
    private LocalDateTime modifiedDate;
}
