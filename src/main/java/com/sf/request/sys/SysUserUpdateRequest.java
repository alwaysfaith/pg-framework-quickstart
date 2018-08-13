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
public class SysUserUpdateRequest extends SysUserBaseRequest {

    @ApiModelProperty("用户ID")
    @NotNull
    private Long userId;

}
