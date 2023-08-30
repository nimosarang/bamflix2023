package com.bamflix.domain.content;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ContentService {

    private final ContentMapper contentMapper;

    private final String uploadPath = Paths.get("C:", "Spring", "bamflix2023", "src", "main", "resources", "images").toString();


    List<ContentResponse> getList() {
        return contentMapper.getList();
    }

    /**
     * 단일 파일 업로드
     * @param params - 파일 객체
     * @return DB에 저장할 파일 정보
     */

   // private void fileSave()
    public void save(@ModelAttribute ContentRequest params,@RequestParam MultipartFile file) {

        String uploadName = generateSaveFilename(String.valueOf(file));
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd")).toString();
        String uploadPath = getUploadPath(today) + File.separator + uploadName;
        params.setOriginalUrl(uploadPath);
        File uploadFile = new File(uploadPath);


        try {
            file.transferTo(uploadFile);

            File thumbnailFile = new File(uploadPath, "s_" + uploadName);
            BufferedImage bo_image = ImageIO.read(uploadFile);
            BufferedImage bt_image = new BufferedImage(300, 500, BufferedImage.TYPE_3BYTE_BGR);

            Graphics2D graphic = bt_image.createGraphics();

            graphic.drawImage(bo_image, 0, 0,300,500, null);

            ImageIO.write(bt_image, "jpg", thumbnailFile);

            params.setThumbUrl(String.valueOf(thumbnailFile));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        contentMapper.save(params);
    }

    /**
     * 저장 파일명 생성
     * @param originalUrl 원본 파일명
     * @return 디스크에 저장할 파일명
     */
    private String generateSaveFilename(String originalUrl) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String extension = StringUtils.getFilenameExtension(originalUrl);
        return uuid + "." + extension;
    }

    /**
     * 업로드 경로 반환
     * @return 업로드 경로
     */
    private String getUploadPath() {
        return makeDirectories(uploadPath);
    }

    /**
     * 업로드 경로 반환
     * @param addPath - 추가 경로
     * @return 업로드 경로
     */
    private String getUploadPath(final String addPath) {
        return makeDirectories(uploadPath + File.separator + addPath);
    }

    /**
     * 업로드 폴더(디렉터리) 생성
     * @param path - 업로드 경로
     * @return 업로드 경로
     */
    private String makeDirectories(final String path) {
        File dir = new File(path);
        if (dir.exists() == false) {
            dir.mkdirs();
        }
        return dir.getPath();
    }

//    public void save(ContentRequest params) {
//        contentMapper.save(params);
//    }

    public void update(ContentRequest params) {
        contentMapper.update(params);
    }

    public void delete(ContentRequest params) {
        contentMapper.delete(params);
    }
}
