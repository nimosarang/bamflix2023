package com.bamflix.domain.content;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ContentService {

    private final ContentMapper contentMapper;

    List<ContentResponse> getList() {
        return contentMapper.getList();
    }

    public void save(ContentRequest params) {
        contentMapper.save(params);
    }

    public void update(ContentRequest params) {
        contentMapper.update(params);
    }

    public void delete(ContentRequest params) {
        contentMapper.delete(params);
    }
}
