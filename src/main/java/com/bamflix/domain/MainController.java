package com.bamflix.domain;

import com.bamflix.domain.member.MemberResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String showMainPage(HttpSession session, Model model) {
        MemberResponse loginMember = (MemberResponse) session.getAttribute("loginMember");

        model.addAttribute("loginMember", loginMember);

        return "index";
    }

    @GetMapping("/main")
    public String showContentMainPage(HttpSession session, Model model) {
        MemberResponse loginMember = (MemberResponse) session.getAttribute("loginMember");

        model.addAttribute("loginMember", loginMember);

        return "content/main";
    }

}



