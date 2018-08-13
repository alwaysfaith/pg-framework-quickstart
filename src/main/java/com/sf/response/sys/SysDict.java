package com.sf.response.sys;

import com.sf.core.converter.DictConverter;
import com.sf.pg.core.convert.Code2Name;
import com.sf.response.CommonField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysDict extends CommonField {

    @ApiModelProperty("字典ID")
    private Long dictId;

    @ApiModelProperty("字典KEY")
    private String dictKey;

    @ApiModelProperty("字典值")
    private String dictValue;

    @ApiModelProperty("字典文字")
    private String dictText;

    @ApiModelProperty("排序")
    private Integer sortNo;

    @ApiModelProperty("有效标识")
    private Boolean validTag;

    @Code2Name(key = "SYS_VALID_TAG", codeFrom = "validTag", converter = DictConverter.class)
    @ApiModelProperty("有效状态-文字")
    private String validTagName;
}