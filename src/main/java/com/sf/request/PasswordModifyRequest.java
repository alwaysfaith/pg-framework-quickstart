package com.sf.request;

import com.sf.pg.exception.InvalidParameterException;
import com.sf.pg.entity.IRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author lijie.zh
 */
@Data
public class PasswordModifyRequest implements IRequest {

    @ApiModelProperty(value = "旧密码")
    @NotBlank
    String oldPassword;

    @ApiModelProperty(value = "新密码")
    @Size(min = 6, max = 16, message = "长度必须在6到16位之间")
    String newPassword;

    @Override
    public void check() throws InvalidParameterException {
        if (getNewPassword().equals(getOldPassword())) {
            throw new InvalidParameterException("新密码和旧密码不能相同");
        }
    }
}
