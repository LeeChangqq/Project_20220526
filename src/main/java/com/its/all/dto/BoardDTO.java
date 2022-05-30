package com.its.all.dto;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class BoardDTO {
    private Long id;
    private String bTitle;
    private String bWriter;
    private String bContents;
    private int bHits;
    private Timestamp bDate;
    private String bFileName;
    private Long mId;

    public Long getId() {
        return id;
    }

    public String getbTitle() {
        return bTitle;
    }

    public String getbWriter() {
        return bWriter;
    }

    public String getbContents() {
        return bContents;
    }

    public int getbHits() {
        return bHits;
    }

    public Timestamp getbDate() {
        return bDate;
    }

    public String getbFileName() {
        return bFileName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setbTitle(String bTitle) {
        this.bTitle = bTitle;
    }

    public void setbWriter(String bWriter) {
        this.bWriter = bWriter;
    }

    public void setbContents(String bContents) {
        this.bContents = bContents;
    }

    public void setbHits(int bHits) {
        this.bHits = bHits;
    }

    public void setbDate(Timestamp bDate) {
        this.bDate = bDate;
    }

    public void setbFileName(String bFileName) {
        this.bFileName = bFileName;
    }
}

