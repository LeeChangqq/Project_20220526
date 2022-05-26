package com.its.all.dto;

import lombok.Data;

@Data
public class MemberDTO {
    private Long id;
    private String mId;
    private String mPass;
    private String mName;
    private String mEmail;
    private String mPhone;
    private String mPro;
}
