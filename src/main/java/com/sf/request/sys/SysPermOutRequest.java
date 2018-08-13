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
public class SysPermOutRequest implements IRequest {

    @ApiModelProperty("权限ID")
    @NotNull
    Long permId;

    @ApiModelProperty("用户ID集合")
    @NotNull
    Long[] userId;

}
