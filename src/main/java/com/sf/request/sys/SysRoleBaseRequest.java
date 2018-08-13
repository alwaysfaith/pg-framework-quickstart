package com.sf.request.sys;

import com.sf.pg.entity.IRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


/**
 * @author lijie.zh
 */
@Getter
@Setter
public class SysRoleBaseRequest implements IRequest {

    @ApiModelProperty("角色名称")
    @NotBlank
    private String roleName;

    @ApiModelProperty("角色编码")
    private String roleCode;

    @ApiModelProperty("角色类型:0-部门，1-公共")
    @NotBlank
    private String roleType;

    @ApiModelProperty("备注")
    private String remark;

}
