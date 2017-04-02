package com.github.ld000.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MindMapDTO {

    @NotNull
    private String content;
    private String selections;

}
