package com.its.all.repository;


import com.its.all.dto.MemberDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {
    @Autowired
    SqlSessionTemplate sql;

    public List<MemberDTO> findAll() {
        return sql.selectList("Member.findAll");
    }

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
    public int update(MemberDTO memberDTO) {
        return sql.update("Member.update", memberDTO);
    }
    public int delete(Long id) {
        return sql.delete("Member.delete", id);
    }

}
