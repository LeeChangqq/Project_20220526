package com.its.all.service;

import com.its.all.dto.MemberDTO;
import com.its.all.dto.PageDTO;
import com.its.all.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public MemberDTO findById(Long id) {
        return memberRepository.findById(id);
    }

    public void save(MemberDTO memberDTO) throws IOException {
        MultipartFile boardFile = memberDTO.getMFile(); // 1.
        String boardFileName = boardFile.getOriginalFilename(); // 2.
        boardFileName = System.currentTimeMillis() + "-" + boardFileName; // 2.1
        memberDTO.setMPro(boardFileName); // 3.
        String savePath = "D:\\spring_img\\" + boardFileName; // 4.
        // 5.
        if(!boardFile.isEmpty()){
            boardFile.transferTo(new File(savePath));
        }
        memberRepository.save(memberDTO);
    }

    public MemberDTO login(MemberDTO memberDTO) {
        return memberRepository.login(memberDTO);
    }

    public String check(String mId) {
        String member = memberRepository.check(mId);
        if(member == null) {
            return "ok";
        }else {
            return "no";
        }
    }
}
