package com.bamflix.domain.content;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ContentController {

    private final ContentService contentService;

    @GetMapping("/detail")
    public String getList(Model model) {
        List<ContentResponse> list = contentService.getList();

        model.addAttribute("list", list);

        return "content/detail";
    }

    @GetMapping("/write")
    public String write() {
        return "content/write";
    }

    @PostMapping("/save")
    public String save(ContentRequest params) {
        contentService.save(params);

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
