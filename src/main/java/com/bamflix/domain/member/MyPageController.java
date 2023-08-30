package com.bamflix.domain.member;

import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {

    private final MemberService memberService;

    @GetMapping
    public String showMyPage(Model model, HttpSession session) {

        MemberResponse memberResponse = (MemberResponse) session.getAttribute("loginMember");

        if (memberResponse == null) {
            return "redirect:/login";
        }

        model.addAttribute("memberResponse", memberResponse);

        return "member/mypage";
    }

}
