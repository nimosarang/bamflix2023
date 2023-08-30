package com.bamflix.domain.content;

import java.io.File;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;


@Service
@RequiredArgsConstructor
public class ContentService {

    private final ContentMapper contentMapper;

    List<ContentResponse> getList() {
        return contentMapper.getList();
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

    public void update(ContentRequest params) {
        contentMapper.update(params);
    }

    public void delete(ContentRequest params) {
        contentMapper.delete(params);
    }
}

