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
}
