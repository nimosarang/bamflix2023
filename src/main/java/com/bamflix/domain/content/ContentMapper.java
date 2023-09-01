package com.bamflix.domain.content;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContentMapper {

    List<ContentResponse> getList();

    void save(ContentRequest params);

    void update(ContentRequest params);

    void delete(ContentRequest params);

    ContentResponse getContent(String title);

    List<ContentResponse> getMovieList();

    List<ContentResponse> getDramaList();

    List<ContentResponse> getEntertainmentList();

    List<ContentResponse> getAnimationList();

    List<ContentResponse> getActionList();

    List<ContentResponse> getComicList();

    List<ContentResponse> getRomanceList();

    List<ContentResponse> getSfList();
}
