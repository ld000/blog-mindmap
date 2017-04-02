package com.github.ld000.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class MindMapPO {

    @JsonIgnore
    private Integer id;
    private String mindMapId;
    private String content;
    private String selections;
    @JsonIgnore
    private String versionNo;
    @JsonIgnore
    private Integer headFlag;  // current version flag， 1-current version
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
