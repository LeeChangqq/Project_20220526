package com.its.all.dto;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class CommentDTO {
    private Long id;
    private Long bId;
    private String cContents;
    private String cWriter;
    private Timestamp cDate;

    public Long getId() {
        return id;
    }

    public Long getbId() {
        return bId;
    }

    public String getcContents() {
        return cContents;
    }

    public String getcWriter() {
        return cWriter;
    }

    public Timestamp getcDate() {
        return cDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setbId(Long bId) {
        this.bId = bId;
    }

    public void setcContents(String cContents) {
        this.cContents = cContents;
    }

    public void setcWriter(String cWriter) {
        this.cWriter = cWriter;
    }

    public void setcDate(Timestamp cDate) {
        this.cDate = cDate;
    }
}
