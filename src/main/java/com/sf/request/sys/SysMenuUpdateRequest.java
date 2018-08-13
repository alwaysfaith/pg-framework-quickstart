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
public class SysMenuUpdateRequest extends SysMenuBaseRequest {

    @ApiModelProperty("菜单ID")
    @NotNull
    private Long menuId;

}
