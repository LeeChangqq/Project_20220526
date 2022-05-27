package com.its.all.controller;

import com.its.all.dto.MemberDTO;
import com.its.all.dto.PageDTO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class BoardController {
//    @GetMapping("/paging")
//    // /board/paging>page=1
//    // required=false로 하면 /board/paging 요청도 가능
//    // 별도의 페이지 값을 요청하지 않으면 첫페이지(page=1)을 보요주자.
//    public String paging(@RequestParam(value="page", required=false, defaultValue="1") int page, Model model) {
//        List<MemberDTO> boardList = memberService.pagingList(page);
//        PageDTO paging = memberService.paging(page);
//        model.addAttribute("boardList", boardList);
//        model.addAttribute("paging", paging);
//        return "member/pagingList";
//    }
}
