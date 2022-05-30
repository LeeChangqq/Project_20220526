package com.its.all.service;


import com.its.all.dto.MemberDTO;
import com.its.all.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public MemberDTO findById(Long id) {
        return memberRepository.findById(id);
    }

    public void save(MemberDTO memberDTO) throws IOException {
        MultipartFile boardFile = memberDTO.getmFile(); // 1.
        String boardFileName = boardFile.getOriginalFilename(); // 2.
        boardFileName = System.currentTimeMillis() + "-" + boardFileName; // 2.1
        memberDTO.setmPro(boardFileName); // 3.
        String savePath = "D:\\spring_img\\" + boardFileName; // 4.
        // 5.
        if (!boardFile.isEmpty()) {
            boardFile.transferTo(new File(savePath));
        }
        memberRepository.save(memberDTO);
    }

    public MemberDTO login(MemberDTO memberDTO) {
        return memberRepository.login(memberDTO);
    }

    public String check(String mId) {
        String member = memberRepository.check(mId);
        if (member == null) {
            return "ok";
        } else {
            return "no";
        }
    }

    public boolean update(MemberDTO memberDTO) {
        System.out.println("memberDTO = " + memberDTO);
        int result = memberRepository.update(memberDTO);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<MemberDTO> findAll() {
        return memberRepository.findAll();
    }

    public boolean delete(Long id) {
        int result = memberRepository.delete(id);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }
}
