package com.its.all.controller;

import com.its.all.dto.MemberDTO;
import com.its.all.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequestMapping("/member")
@Controller
public class MemberController {
    @Autowired
    MemberService memberService;
    @GetMapping("/save-form")
    public String saveForm() {
        return "member/save";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        boolean result = memberService.save(memberDTO);
        if(result) {
            return "member/login";
        }else {
            return "member/save";

        }
    }
    @GetMapping("/detail")
    public String findById(@RequestParam("id") Long id, Model model){
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member", memberDTO);
        return "member/detail";
    }


    @GetMapping("/login-form")
    public String loginForm() {
        return "member/login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session, Model model) {
        MemberDTO result = memberService.login(memberDTO);
        if(result == null){
            return "member/login";
        }else {
            session.setAttribute("memberId",result.getId());
            session.setAttribute("memberMId",result.getMId());
            model.addAttribute("member", result);
            return "index";
        }
    }
    @PostMapping("/loginCheck")
    public String idCheck() {
        return null;
    }
}