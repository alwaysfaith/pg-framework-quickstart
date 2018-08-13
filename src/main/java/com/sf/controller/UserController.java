package com.sf.controller;

import com.sf.dao.model.TfSysUser;
import com.sf.pg.context.ActionHolder;
import com.sf.pg.core.log.define.AccessLogger;
import com.sf.pg.entity.R;
import com.sf.pg.exception.BusinessException;
import com.sf.request.PasswordModifyRequest;
import com.sf.response.User;
import com.sf.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijie.zh
 */
@RestController
@Slf4j
@RequestMapping("/user")
@Api(tags = {"用户相关接口"})
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ActionHolder actionHolder;

    @ApiOperation("获取登录用户详细信息")
    @AccessLogger
    @GetMapping("/get")
    public R<User> getUser() {
        Long userId = actionHolder.getUserId();

        TfSysUser tfSysUser = userService.queryUserByUserId(userId);

        User user = new User();
        user.setUserId(userId.toString());
        user.setUserName(tfSysUser.getUserName());
        user.setMobileNo(tfSysUser.getMobileNo());
        user.setAvatar(tfSysUser.getAvatar());
        return R.success(user);
    }

    @ApiOperation(value = "修改密码")
    @AccessLogger(ignoreParameters = {"newPassword","oldPassword"})
    @PostMapping("/password/modify")
    public R modify(PasswordModifyRequest request) {
        Long userId = actionHolder.getUserId();
        if(!userService.checkPassword(userId,request.getOldPassword())){
            throw new BusinessException("原密码错误");
        }
        userService.updatePassword(userId,request.getNewPassword());
        return R.success("修改成功");
    }


}