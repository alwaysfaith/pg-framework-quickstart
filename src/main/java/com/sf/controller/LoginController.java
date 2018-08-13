package com.sf.controller;

import com.sf.request.LoginRequest;
import com.sf.response.LoginResponse;
import com.sf.pg.core.log.define.AccessLogger;
import com.sf.pg.entity.R;
import com.sf.pg.security.auth.shiro.AuthUtils;
import com.sf.pg.security.auth.shiro.token.AuthcToken;
import com.sf.pg.security.auth.shiro.token.TokenEntity;
import com.sf.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author lijie.zh
 */
@Api(tags = {"用户登录相关接口"})
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "用户登录")
    @AccessLogger(ignoreParameters = {"password"})
    @PostMapping("/login")
    public R<LoginResponse> login(LoginRequest request) {
        TokenEntity tokenEntity = loginService.doLogin(request.getLoginName(), request.getPassword());
        SecurityUtils.getSubject().login(new AuthcToken(tokenEntity.getUserId(), tokenEntity.getTokenId()));

        LoginResponse response = new LoginResponse();
        String authToken = AuthUtils.buildToken(tokenEntity.getUserId(),tokenEntity.getTokenId());
        response.setAuthToken(authToken);
        response.setUserId(tokenEntity.getUserId());
        //注意，login这里不能使用UserUtils类获取，因为login方法没有header认证信息
        //response.setUserName(((CurrentUser)tokenEntity.getContext()).getUserName());
        loginService.afterLogin(Long.parseLong(tokenEntity.getUserId()));
        return R.success(response);
    }

    @ApiOperation(value = "用户退出")
    @AccessLogger
    @PostMapping("/logout")
    public R logout() {
        //退出工作由logoutFilter执行，这里只做消息提示
        return R.success("退出成功");
    }
}
