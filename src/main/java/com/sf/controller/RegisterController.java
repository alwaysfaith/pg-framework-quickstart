package com.sf.controller;

import com.sf.request.RegisterRequest;
import com.sf.dao.model.TfSysUser;
import com.sf.dao.model.TfSysUserPassword;
import com.sf.pg.core.log.define.AccessLogger;
import com.sf.pg.entity.R;
import com.sf.core.auth.PasswordEncoder;
import com.sf.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


/**
 * @author lijie.zh
 */
@Slf4j
@Api(tags = {"用户注册相关接口"})
@RestController
public class RegisterController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户注册")
    @AccessLogger(ignoreParameters = {"password"})
    @PostMapping("register")
    public R register(RegisterRequest request) {
        TfSysUser tfSysUser = new TfSysUser();
        tfSysUser.setMobileNo(request.getMobileNo());
        tfSysUser.setStaffId(request.getStaffId());
        tfSysUser.setUserName(request.getUserName());
        tfSysUser.setEmail(request.getEmail());

        Long userId = tfSysUser.getUserId();
        TfSysUserPassword tfSysUserPassword = new TfSysUserPassword();
        tfSysUserPassword.setUserId(userId);
        tfSysUserPassword.setPassword(PasswordEncoder.getEncryptedPwd(request.getPassword()));
        tfSysUserPassword.setLastUpdateTime(new Date());

        userService.register(tfSysUser,tfSysUserPassword);
        return R.success("注册成功");
    }
}
