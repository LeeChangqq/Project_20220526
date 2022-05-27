package com.its.all.repository;

import com.its.all.dto.BoardDTO;
import com.its.all.dto.MemberDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class MemberRepository {
    @Autowired
    SqlSessionTemplate sql;

    public MemberDTO findById(Long id) {
        return sql.selectOne("Member.findById", id);
    }

    public int save(MemberDTO memberDTO) {
        return sql.insert("Member.save", memberDTO);
    }

    public MemberDTO login(MemberDTO memberDTO) {
        return sql.selectOne("Member.login", memberDTO);
    }

    public String check(String mId) {
        return sql.selectOne("Member.check", mId);
    }
}
