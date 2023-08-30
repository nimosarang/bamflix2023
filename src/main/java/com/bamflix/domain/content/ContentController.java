package com.bamflix.domain.content;

import com.bamflix.domain.member.MemberResponse;
import javax.servlet.http.HttpSession;
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

    @GetMapping("/main")
    public String getList(Model model, HttpSession session) {
        List<ContentResponse> contents = contentService.getList();
        model.addAttribute("contents", contents);

        MemberResponse loginMember = (MemberResponse) session.getAttribute("loginMember");
        model.addAttribute("loginMember", loginMember);
        return "content/main";
    }

    @GetMapping("/write")
    public String write(Model model) {
        return "content/write";
    }

    @PostMapping("/save")
    public String save(ContentRequest content, MultipartFile imgFile) throws Exception {

        contentService.saveContent(content, imgFile);

        return "content/detail";
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
