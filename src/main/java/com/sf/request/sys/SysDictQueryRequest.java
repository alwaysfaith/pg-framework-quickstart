package com.sf.request.sys;

import com.sf.pg.entity.PageRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * @author lijie.zh
 */
@Getter
@Setter
public class SysDictQueryRequest extends PageRequest {

    @ApiModelProperty("字典KEY")
    private String dictKey;

    @ApiModelProperty("字典值")
    private String dictValue;

    @ApiModelProperty("字典文字")
    private String dictText;

    @ApiModelProperty("有效标识")
    private Boolean validTag;

}
