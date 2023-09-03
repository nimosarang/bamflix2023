package com.bamflix.domain.content;

import java.io.File;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
@RequiredArgsConstructor
public class ContentService {

    private final ContentMapper contentMapper;

    List<ContentResponse> getList() {
        return contentMapper.getList();
    }

    ContentResponse getContent(String title) {
        return contentMapper.getContent(title);
    }

    public List<ContentResponse> getCategoryList(String category) {
        return contentMapper.getCategoryList(category);
    }

    public List<ContentResponse> getGenreList(String genre) {
        return contentMapper.getGenreList(genre);
    }

    public List<ContentResponse> getSearchList(String title) {
        return contentMapper.getSearchList(title);
    }

    public void saveContent(ContentRequest content, MultipartFile imgFile) throws Exception {

        String oriImgName = imgFile.getOriginalFilename();
        String imgName = "";

        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files/";

        UUID uuid = UUID.randomUUID();

        imgName = uuid + "_" + oriImgName;

        File saveFile = new File(projectPath, imgName);

        imgFile.transferTo(saveFile);

        content.setImgName(imgName);
        content.setImgPath("/files/" + imgName);

        contentMapper.save(content);
    }

    public void updateContent(ContentRequest content, MultipartFile imgFile) throws Exception {

        String oriImgName = imgFile.getOriginalFilename();
        String imgName = "";

        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files/";

        UUID uuid = UUID.randomUUID();

        imgName = uuid + "_" + oriImgName;

        File saveFile = new File(projectPath, imgName);

        imgFile.transferTo(saveFile);

        content.setImgName(imgName);
        content.setImgPath("/files/" + imgName);

        contentMapper.update(content);
    }

    public void delete(ContentRequest params) {
        contentMapper.delete(params);
    }
}

