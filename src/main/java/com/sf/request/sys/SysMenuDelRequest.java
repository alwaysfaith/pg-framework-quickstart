package com.sf.request.sys;

import com.sf.pg.entity.IRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;


/**
 * @author lijie.zh
 */
@Getter
@Setter
public class SysMenuDelRequest implements IRequest {

    @ApiModelProperty("菜单ID")
    @NotNull
    Long[] menuId;

}
