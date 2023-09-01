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

    @GetMapping("/movie")
    public String movie(Model model) {
        List<ContentResponse> movies = contentService.getMovieList();
        model.addAttribute("contents", movies);

        return "content/categoryContent";
    }

    @GetMapping("/drama")
    public String drama(Model model) {
        List<ContentResponse> dramas = contentService.getDramaList();
        model.addAttribute("contents", dramas);

        return "content/categoryContent";
    }

    @GetMapping("/entertainment")
    public String entertainment(Model model) {
        List<ContentResponse> entertainments = contentService.getEntertainmentList();
        model.addAttribute("contents", entertainments);

        return "content/categoryContent";
    }

    @GetMapping("/animation")
    public String animation(Model model) {
        List<ContentResponse> animations = contentService.getAnimationList();
        model.addAttribute("contents", animations);

        return "content/categoryContent";
    }

    @GetMapping("/action")
    public String action(Model model) {
        List<ContentResponse> actions = contentService.getActionList();
        model.addAttribute("contents", actions);

        return "content/genreContent";
    }

    @GetMapping("/romance")
    public String romance(Model model) {
        List<ContentResponse> romances = contentService.getRomanceList();
        model.addAttribute("contents", romances);

        return "content/genreContent";
    }

    @GetMapping("/comic")
    public String comic(Model model) {
        List<ContentResponse> comics = contentService.getComicList();
        model.addAttribute("contents", comics);

        return "content/genreContent";
    }

    @GetMapping("/sf")
    public String sf(Model model) {
        List<ContentResponse> sfs = contentService.getSfList();
        model.addAttribute("contents", sfs);

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
