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
public class SysPermBaseRequest implements IRequest {

    @ApiModelProperty("权限名称")
    @NotBlank
    private String permName;

    @ApiModelProperty("权限编码")
    @NotBlank
    private String permCode;

    /**
     * 权限类型:M-菜单，F-功能权限，D-数据
     */
    @ApiModelProperty("权限类型")
    @NotBlank
    private String permType;

    @ApiModelProperty("备注")
    private String remark;


}
