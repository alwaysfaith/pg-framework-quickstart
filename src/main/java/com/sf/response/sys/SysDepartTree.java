package com.sf.response.sys;

import com.sf.core.converter.DictConverter;
import com.sf.pg.core.convert.Code2Name;
import com.sf.response.CommonField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysDepartTree {

    @ApiModelProperty("部门ID")
    private Long deptId;

    @ApiModelProperty("部门名称")
    private String deptName;

    @ApiModelProperty("上级部门ID")
    private Long parentDeptId;

    @ApiModelProperty("部门层级")
    private String deptFrame;
}