package com.sf.response.component;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Selection {

    @ApiModelProperty("值")
    private String value;

    @ApiModelProperty("文字")
    private String text;

}