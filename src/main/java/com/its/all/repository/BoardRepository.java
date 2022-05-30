package com.its.all.repository;

import com.its.all.dto.BoardDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public class BoardRepository {
    @Autowired
    SqlSessionTemplate sql;
    public int save(BoardDTO boardDTO) {
        return sql.insert("Board.save",boardDTO);
    }
    public int boardCount() {
        return sql.selectOne("Board.count");
    }

    public List<BoardDTO> pagingList(Map<String, Integer> pagingParam) {
        return sql.selectList("Board.pagingList", pagingParam);
    }

    public BoardDTO findById(Long id) {
        sql.update("Board.hits", id);
        return sql.selectOne("Board.findById", id);
    }
    public void delete(Long id) {
        sql.delete("Board.delete",id);
    }

    public int update(BoardDTO boardDTO) {
        return sql.update("Board.update", boardDTO);
    }
    public List<BoardDTO> search(Map<String, String> searchParam) {
        return sql.selectList("Board.search", searchParam);
    }

}