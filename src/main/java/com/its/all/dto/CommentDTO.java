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
}
