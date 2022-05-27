package com.its.all.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MemberDTO {
    private Long id;
    private String mId;
    private String mPass;
    private String mPass2;
    private String mName;
    private String mEmail;
    private String mPhone;
    private String mPro;
    private MultipartFile mFile;
}
