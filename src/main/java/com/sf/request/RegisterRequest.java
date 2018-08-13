package com.sf.request;

import com.sf.pg.entity.IRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author lijie.zh
 */
@Data
public class RegisterRequest implements IRequest {

    @ApiModelProperty(value = "用户名", required = true)
    @NotBlank
    String userName;

    @ApiModelProperty(value = "密码", required = true)
    @Size(min=6, max=16, message = "长度必须在6到16位之间")
    String password;

    @ApiModelProperty(value = "工号", required = true)
    @Size(min=6, max=10, message = "长度必须在6到16位之间")
    String staffId;

    @ApiModelProperty(value = "手机号码")
    String mobileNo;

    @ApiModelProperty(value = "邮箱")
    String email;
}