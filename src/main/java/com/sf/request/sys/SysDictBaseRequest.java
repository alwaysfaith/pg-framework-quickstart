package com.sf.request.sys;

import com.sf.pg.entity.IRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * @author lijie.zh
 */
@Getter
@Setter
public class SysDictBaseRequest implements IRequest {

    @ApiModelProperty("字典KEY")
    @NotBlank
    private String dictKey;

    @ApiModelProperty("字典值")
    @NotBlank
    private String dictValue;

    @ApiModelProperty("字典文字")
    @NotBlank
    private String dictText;

    @ApiModelProperty("排序")
    @NotNull
    private Integer sortNo;

}
