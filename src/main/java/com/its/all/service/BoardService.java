package com.its.all.service;

import com.its.all.dto.MemberDTO;
import com.its.all.dto.PageDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardService {
//    private static final int PAGE_LIMIT = 3; // 한페이지에 보여줄 글 갯수
//    private static final int BLOCK_LIMIT = 3; // 페이지 번호 갯수
//
//    /**
//     * 요청한 페이지에 해당하는 글 목록을 DB에서 가져오는 역할
//     */
//    public List<MemberDTO> pagingList(int page) {
//        // 1페이지 요청=>
//        int pagingStart = (page-1) * PAGE_LIMIT;
//        Map<String, Integer> pagingParam = new HashMap<>();
//        pagingParam.put("start", pagingStart);
//        pagingParam.put("limit", PAGE_LIMIT);
//        List<MemberDTO> pagingList = memberRepository.pagingList(pagingParam);
//        return pagingList;
//    }
//
//    public PageDTO paging(int page) {
//        int boardCount = memberRepository.boardCount(); // 글 갯수 조회
//        // 필요한 전체 페이지 갯수
//        // 10, 3 10/3 = 3.3333 => (4 => Math.ceil로 올림을 처리함)
//        int maxPage = (int)(Math.ceil((double)boardCount / PAGE_LIMIT));
//        // 시작페이지 1 4 7 10 ~~~
//        int startPage = (((int)(Math.ceil((double)page / BLOCK_LIMIT))) - 1) * BLOCK_LIMIT + 1;
//        // 끝페이지 3 6 9 12 ~~~
//        int endPage = startPage + BLOCK_LIMIT - 1;
//        if(endPage > maxPage) // 끝페이지가 3 6 9지만 endpage랑 그 값을 맞춰서 필요 없는 페이지를 안만든다
//            endPage = maxPage;
//        PageDTO paging = new PageDTO();
//        paging.setPage(page);
//        paging.setStartPage(startPage);
//        paging.setEndPage(endPage);
//        paging.setMaxPage(maxPage);
//        return paging;
//    }
}
