package com.sf.response.sys;

import com.sf.core.converter.DictConverter;
import com.sf.pg.core.convert.Code2Name;
import com.sf.response.CommonField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysPerm extends CommonField {

    @ApiModelProperty("权限ID")
    private Long permId;

    @ApiModelProperty("权限名称")
    private String permName;

    @ApiModelProperty("权限编码")
    private String permCode;

    @ApiModelProperty("权限类型：M-菜单权限，F-功能权限，D-数据权限")
    private String permType;

    @ApiModelProperty("权限类型-名称")
    @Code2Name(key = "SYS_PERM_TYPE", codeFrom = "permType", converter = DictConverter.class)
    private String permTypeName;

    @ApiModelProperty("有效标识")
    private Boolean validTag;

    @Code2Name(key = "SYS_VALID_TAG", codeFrom = "validTag", converter = DictConverter.class)
    @ApiModelProperty("有效状态-文字")
    private String validTagName;

    @ApiModelProperty("备注")
    private String remark;

}