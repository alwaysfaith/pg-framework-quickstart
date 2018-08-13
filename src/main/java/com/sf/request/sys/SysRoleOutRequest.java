package com.sf.request.sys;

import com.sf.pg.entity.IRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * @author lijie.zh
 */
@Getter
@Setter
public class SysRoleOutRequest implements IRequest {

    @ApiModelProperty("角色ID")
    @NotBlank
    Long roleId;

    @ApiModelProperty("用户ID")
    @NotNull
    Long[] userId;

}
