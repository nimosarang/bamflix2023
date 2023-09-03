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

    List<ContentResponse> getCategoryList(String category);

    List<ContentResponse> getGenreList(String genre);

    List<ContentResponse> getSearchList(String title);
}
