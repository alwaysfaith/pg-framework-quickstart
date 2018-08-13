package com.sf.request.sys;

import com.sf.pg.entity.PageRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 * @author lijie.zh
 */
@Getter
@Setter
public class SysUserBaseRequest  {

    @ApiModelProperty("用户名")
    @NotEmpty
    private String userName;

    @ApiModelProperty("工号ID")
    @NotEmpty
    private String staffId;

    @ApiModelProperty("手机号码")
    private String mobileNo;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "部门ID")
    private Long deptId;
}
