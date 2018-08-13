package com.sf.request.sys;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;


/**
 * @author lijie.zh
 */
@Getter
@Setter
public class SysRoleUpdateRequest extends SysRoleBaseRequest {
    @ApiModelProperty("角色ID")
    @NotNull
    Long roleId;
}
