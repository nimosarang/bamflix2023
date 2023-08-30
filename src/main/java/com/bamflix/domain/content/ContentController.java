package com.bamflix.domain.content;


import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ContentController {

    private final ContentService contentService;

    private Logger logger = LoggerFactory.getLogger(ContentController.class);

    @GetMapping("/detail")
    public String getList(Model model) {
        List<ContentResponse> list = contentService.getList();
        model.addAttribute("list", list);

        return "content/detail";
    }

    @GetMapping("/write")
    public String write(Model model, ContentRequest contentRequest) {
        model.addAttribute("contentRequest", contentRequest);
        return "content/write";
    }


    @PostMapping("/save")
    public String save(ContentRequest contentRequest,@RequestParam MultipartFile file) {

        contentService.save(contentRequest,file);

        return "redirect:detail";
    }

    @GetMapping("/update")
    public String update() {
        return "content/update";
    }

    @PostMapping("/update")
    public String update(ContentRequest params) {
        contentService.update(params);

        return "redirect:detail";
    }

    @GetMapping("/delete")
    public String delete() {
        return "content/delete";
    }

    @PostMapping("/delete")
    public String delete(ContentRequest params) {
        contentService.delete(params);

        return "redirect:detail";
    }
}
