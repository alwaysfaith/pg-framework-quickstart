package com.sf.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * @author lijie.zh
 */
@Getter
@Setter
public class User implements Serializable {

    @ApiModelProperty("用户ID")
    String userId;

    @ApiModelProperty("用户名")
    String userName;

    @ApiModelProperty("手机号码")
    String mobileNo;

    @ApiModelProperty("头像")
    String avatar;
}
