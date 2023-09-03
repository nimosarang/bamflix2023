package com.bamflix.domain.content;

import com.bamflix.domain.member.MemberResponse;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ContentController {

    private final ContentService contentService;

    @GetMapping("/main")
    public String getList(Model model, HttpSession session) {
        List<ContentResponse> contents = contentService.getList();
        model.addAttribute("contents", contents);

        MemberResponse loginMember = (MemberResponse) session.getAttribute("loginMember");
        model.addAttribute("loginMember", loginMember);
        return "content/main";
    }

    @GetMapping("/contentDetail")
    public String contentDetail(Model model, String title, HttpSession session) {
        ContentResponse content = contentService.getContent(title);
        model.addAttribute("content", content);

        MemberResponse loginMember = (MemberResponse) session.getAttribute("loginMember");
        model.addAttribute("loginMember", loginMember);

        return "content/contentDetail";
    }

    @GetMapping("/write")
    public String write() {
        return "content/write";
    }

    @PostMapping("/save")
    public String save(ContentRequest content, MultipartFile imgFile) throws Exception {

        contentService.saveContent(content, imgFile);

        return "redirect:detail";
    }

    @GetMapping("/detail")
    public String detail(Model model) {
        List<ContentResponse> contents = contentService.getList();
        model.addAttribute("contents", contents);

        return "content/detail";
    }

    @GetMapping("/category")
    public String category(Model model, String category) {
        List<ContentResponse> categorys = contentService.getCategoryList(category);
        model.addAttribute("contents", categorys);

        return "content/categoryContent";
    }

    @GetMapping("/genre")
    public String genre(Model model, String genre) {
        String genreTitle = genre;
        model.addAttribute("genreTitle", genreTitle);
        List<ContentResponse> genres = contentService.getGenreList(genre);
        model.addAttribute("contents", genres);

        return "content/genreContent";
    }

    @GetMapping("/update")
    public String update() {
        return "content/update";
    }

    @PostMapping("/update")
    public String update(ContentRequest content, MultipartFile imgFile) throws Exception {
        contentService.updateContent(content, imgFile);

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
