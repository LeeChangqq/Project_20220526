package com.its.all.controller;


import com.its.all.dto.MemberDTO;
import com.its.all.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

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
    public String save(@ModelAttribute MemberDTO memberDTO) throws IOException {
        memberService.save(memberDTO);
        return "member/login";
    }
    @PostMapping("/check")
    public @ResponseBody String check(@RequestParam("mId") String mId) {
        System.out.println("mId = " + mId);
        String check = memberService.check(mId);
        return check;
    }



    @GetMapping("/detail")
    public String findById(@RequestParam("id") Long id, Model model){
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member", memberDTO);
        return "member/detail1";
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
        } else {
            session.setAttribute("memberId",result.getId());
            session.setAttribute("memberMId",result.getmId());
            session.setAttribute("memberMPass",result.getmPass());
            session.setAttribute("memberPass2",result.getmPass2());
            session.setAttribute("memberName",result.getmName());
            session.setAttribute("memberEmail",result.getmEmail());
            session.setAttribute("memberPhone",result.getmPhone());
            session.setAttribute("memberPro",result.getmPro());
            model.addAttribute("member", result);
            return "redirect:/board/paging";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }
    @GetMapping("/update-form")
    public String updateForm(HttpSession session, Model model) {
        // 로그인을 한 상태기 때문에 세션에 id, memberId가 들어있고
        // 여기서 세션에 있는 id를 가져온다
        Long updateId = (Long) session.getAttribute("memberId");
        System.out.println("updateId = " + updateId);
        // DB에서 해당 회원의 정보를 가져와서 그 정보를 가지고 update.jsp로 이동
        MemberDTO memberDTO = memberService.findById(updateId);
        model.addAttribute("updateMember", memberDTO);
        return "member/myPage";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute MemberDTO memberDTO){
        boolean result = memberService.update(memberDTO);
        if(result) {
            // 해당 회원이 상세정보
            return "redirect:/member/detail?id=" + memberDTO.getId();
        }else {
            return "update-fail";
        }

    }
    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("member",memberDTOList);
        return "member/list";
    }
    @GetMapping("/delete")
    public String delete (@RequestParam("id") Long id) {
        boolean result = memberService.delete(id);
        if(result) {
            return "redirect:/member/findAll";
        }else {
            return "delete-fail";
        }
    }
}