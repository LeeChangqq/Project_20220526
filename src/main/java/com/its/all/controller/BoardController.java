package com.its.all.controller;

import com.its.all.dto.BoardDTO;
import com.its.all.dto.CommentDTO;
import com.its.all.dto.PageDTO;
import com.its.all.service.BoardService;
import com.its.all.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/board")
@Controller
public class BoardController {
    @Autowired
    BoardService boardService;
    @Autowired
    CommentService commentService;
    @GetMapping("/save-form")
    public String saveFrom() {
        return "board/save";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO){
        boolean result = boardService.save(boardDTO);
        if (result) {
            return "redirect:/board/paging";
            //return "/board/list";
        } else {
            return "board/save";
        }
    }
    @GetMapping("/paging")
    public String paging(@RequestParam(value="page", required=false, defaultValue="1") int page, Model model) {
        List<BoardDTO> boardList = boardService.pagingList(page);
        PageDTO paging = boardService.paging(page);
        model.addAttribute("boardList", boardList);
        model.addAttribute("paging", paging);
        return "board/pagingList";
    }
    @GetMapping("/detail")
    public String findById(@RequestParam Long id, Model model){
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("boardDTO",boardDTO);
        List<CommentDTO> commentDTOList = commentService.findAll(id);
        model.addAttribute("commentList", commentDTOList);
        return "board/detail";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        boardService.delete(id);
        return "redirect:/board/paging";
    }
    @GetMapping("/update")
    public String updateForm(@RequestParam Long id, Model model) {
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "board/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO, Model model){
        boolean result = boardService.update(boardDTO);
        System.out.println("result = " + result);
        model.addAttribute("board", boardDTO);
        if(result) {
            // 해당 회원이 상세정보
            return "redirect:/board/detail?id=" + boardDTO.getId(); // 수정처리 후 상세페이지 요청
        }else {
            return "update-fail";
        }

    }
    @GetMapping("/search")
    public String search(@RequestParam("searchType") String searchType, @RequestParam("q") String q, Model model, @RequestParam(value="page", required=false, defaultValue="1") int page){
        List<BoardDTO> searchList = boardService.search(searchType, q);
        PageDTO paging = boardService.paging(page);
        model.addAttribute("boardList", searchList);
        model.addAttribute("paging", paging);
        return "/board/searchList";
    }
    @GetMapping("/check")
    public String check(@RequestParam("id") Long id, Model model) {
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "board/check";
    }
    @GetMapping("/check2")
    public String check2(@RequestParam("id") Long id, Model model) {
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "board/check2";
    }
}