package com.sf.response;

import com.sf.core.converter.UserConverter;
import com.sf.pg.core.convert.Code2Name;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author lijie.zh
 */
@Getter
@Setter
public class LoginResponse {

    @ApiModelProperty(value = "登录成功分配的TOKEN")
    String authToken;

    @ApiModelProperty(value = "用户标识")
    String userId;

    @Code2Name(codeFrom = "userId", converter = UserConverter.class)
    @ApiModelProperty(value = "用户名")
    String userName;
}
