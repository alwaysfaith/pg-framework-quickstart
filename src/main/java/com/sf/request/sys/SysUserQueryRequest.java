package com.sf.request.sys;

import com.sf.pg.entity.PageRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


/**
 * @author lijie.zh
 */
@Getter
@Setter
public class SysUserQueryRequest extends PageRequest {

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("工号ID")
    private String staffId;

    @ApiModelProperty("手机号码")
    private String mobileNo;

    @ApiModelProperty("部门ID")
    private Long deptId;

}
