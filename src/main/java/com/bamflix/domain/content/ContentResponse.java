package com.bamflix.domain.content;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ContentResponse {

    private Long id;
    private String title;
    private String summary;
    private String videoUrl;
    private String thumbUrl;
    private String imgName;
    private String imgPath;
    private LocalDateTime uploadedAt;
    private String createCountry;
    private String createYear;
    private Boolean isSubscribeYn;
    private Category category;
    private Genre genre;
    private String director;
    private Integer price;
    private Boolean deleteYn;
    private LocalDateTime modifiedDate;

}
