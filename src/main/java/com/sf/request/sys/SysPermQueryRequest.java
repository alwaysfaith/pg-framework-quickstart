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
public class SysPermQueryRequest extends PageRequest {

    @ApiModelProperty("权限名称")
    private String permName;

    @ApiModelProperty("权限编码")
    private String permCode;

    @ApiModelProperty("权限类型：M-菜单权限，F-功能权限，D-数据权限")
    private String permType;

}
