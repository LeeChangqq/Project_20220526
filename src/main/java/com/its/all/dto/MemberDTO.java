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

    public Long getId() {
        return id;
    }

    public String getmId() {
        return mId;
    }

    public String getmPass() {
        return mPass;
    }

    public String getmPass2() {
        return mPass2;
    }

    public String getmName() {
        return mName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public String getmPhone() {
        return mPhone;
    }

    public String getmPro() {
        return mPro;
    }

    public MultipartFile getmFile() {
        return mFile;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public void setmPass(String mPass) {
        this.mPass = mPass;
    }

    public void setmPass2(String mPass2) {
        this.mPass2 = mPass2;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public void setmPro(String mPro) {
        this.mPro = mPro;
    }

    public void setmFile(MultipartFile mFile) {
        this.mFile = mFile;
    }
}
