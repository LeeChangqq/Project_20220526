package com.its.all.service;

import com.its.all.dto.BoardDTO;
import com.its.all.dto.PageDTO;
import com.its.all.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;

    public boolean save(BoardDTO boardDTO) {
        int board = boardRepository.save(boardDTO);
        if (board > 0) {
            return true;
        } else {
            return false;
        }
    }
    private static final int PAGE_LIMIT = 5; // 한페이지에 보여줄 글 갯수
    private static final int BLOCK_LIMIT = 3; // 페이지 번호 갯수
    public List<BoardDTO> pagingList(int page) {
        // 1페이지 요청=>
        int pagingStart = (page-1) * PAGE_LIMIT;
        Map<String, Integer> pagingParam = new HashMap<>();
        pagingParam.put("start", pagingStart);
        pagingParam.put("limit", PAGE_LIMIT);
        List<BoardDTO> pagingList = boardRepository.pagingList(pagingParam);
        return pagingList;
    }

    public PageDTO paging(int page) {
        int boardCount = boardRepository.boardCount(); // 글 갯수 조회
        // 필요한 전체 페이지 갯수
        // 10, 3 10/3 = 3.3333 => (4 => Math.ceil로 올림을 처리함)
        int maxPage = (int)(Math.ceil((double)boardCount / PAGE_LIMIT));
        // 시작페이지 1 4 7 10 ~~~
        int startPage = (((int)(Math.ceil((double)page / BLOCK_LIMIT))) - 1) * BLOCK_LIMIT + 1;
        // 끝페이지 3 6 9 12 ~~~
        int endPage = startPage + BLOCK_LIMIT - 1;
        if(endPage > maxPage) // 끝페이지가 3 6 9지만 endpage랑 그 값을 맞춰서 필요 없는 페이지를 안만든다
            endPage = maxPage;
        PageDTO paging = new PageDTO();
        paging.setPage(page);
        paging.setStartPage(startPage);
        paging.setEndPage(endPage);
        paging.setMaxPage(maxPage);
        return paging;
    }

    public BoardDTO findById(Long id) {
        return boardRepository.findById(id);
    }
    public void delete(Long id) {
        boardRepository.delete(id);
    }

    public boolean update(BoardDTO boardDTO) {
        int result = boardRepository.update(boardDTO);
        if(result > 0) {
            return true;
        }else {
            return false;
        }
    }
    public List<BoardDTO> search(String searchType, String q) {
        Map<String, String> searchParam = new HashMap<>();
        searchParam.put("type", searchType);
        searchParam.put("q", q);
        List<BoardDTO> searchList = boardRepository.search(searchParam);
        return searchList;
    }
}