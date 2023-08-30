package com.bamflix.domain.content;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContentRequest {

    private Long id;
    private String title;
    private String summary;
    private String videoUrl;
    private String thumbUrl;
    private String imgName;
    private String imgPath;
    private String createCountry;
    private String createYear;
    private Boolean isSubscribeYn;
    private String director;
    private Integer price;

}



