package com.sf.request;

import com.sf.pg.entity.IRequest;
import lombok.Data;

import javax.validation.constraints.NotBlank;


/**
 * @author lijie.zh
 */
@Data
public class LoginRequest implements IRequest {

    @NotBlank
    String loginName;

    @NotBlank
    String password;


    String verifyCode;
}
