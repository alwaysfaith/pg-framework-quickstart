package com.sf.controller.sys;

import com.sf.dao.model.TfSysUser;
import com.sf.dao.model.TfSysUserPassword;
import com.sf.pg.constant.ErrorStatusEnum;
import com.sf.pg.core.log.define.AccessLogger;
import com.sf.pg.core.mybatis.util.PageHelper;
import com.sf.pg.entity.PageList;
import com.sf.pg.entity.R;
import com.sf.request.sys.SysUserAddRequest;
import com.sf.request.sys.SysUserQueryRequest;
import com.sf.request.sys.SysUserUpdateRequest;
import com.sf.response.sys.SysUser;
import com.sf.service.sys.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * @author lijie.zh
 */

@Api(tags = {"系统管理-用户"})
@RestController
@Slf4j
@RequestMapping("/sys/user")
@AccessLogger
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation("用户列表")
    @GetMapping("/list")
    @RequiresPermissions("sys:user:list")
    public R<PageList<SysUser>> list(SysUserQueryRequest request) {
        TfSysUser tfSysUser = new TfSysUser();
        BeanUtils.copyProperties(request, tfSysUser);
        PageList<TfSysUser> list = sysUserService.list(tfSysUser, request.getPagination());
        return R.success(PageHelper.convert(list, SysUser.class));
    }

    @ApiOperation("用户详情")
    @GetMapping("/get")
    @RequiresPermissions("sys:user:get")
    public R<SysUser> get(@NotNull Long userId) {
        TfSysUser tfSysUser = sysUserService.get(userId);
        if (null == tfSysUser) {
            return R.error(ErrorStatusEnum.DATA_NOTFUND.getText());
        }
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(tfSysUser, sysUser);
        return R.success(sysUser);
    }

    @ApiOperation("修改用户")
    @PostMapping("/update")
    @RequiresPermissions("sys:user:update")
    public R get(SysUserUpdateRequest request) {
        TfSysUser tfSysUser = new TfSysUser();
        BeanUtils.copyProperties(request, tfSysUser);
        sysUserService.update(tfSysUser);
        return R.success("修改成功");
    }

    @ApiOperation("新增用户")
    @PostMapping("/add")
    @RequiresPermissions("sys:user:add")
    public R get(SysUserAddRequest request) {
        TfSysUser tfSysUser = new TfSysUser();
        BeanUtils.copyProperties(request,tfSysUser);

        Long userId = tfSysUser.getUserId();
        TfSysUserPassword tfSysUserPassword = new TfSysUserPassword();
        tfSysUserPassword.setUserId(userId);
        tfSysUserPassword.setLastUpdateTime(new Date());

        sysUserService.add(tfSysUser, tfSysUserPassword);
        return R.success("新增成功");
    }

    @ApiOperation("删除用户")
    @PostMapping("/del")
    @RequiresPermissions("sys:user:del")
    public R del(@NotNull Long[] userId) {
        for (Long id : userId) {
            sysUserService.del(id);
        }
        return R.success("删除成功");
    }

    @ApiOperation("重置密码")
    @PostMapping("/password/reset")
    @RequiresPermissions("sys:user:passwordreset")
    public R resetPassword(@NotNull Long[] userId) {
        String password="";
        for (Long id : userId) {
            String newPassword = sysUserService.resetPassword(id);
            if(StringUtils.isBlank(password)){
                password = newPassword;
            }
        }
        return R.success("重置成功，新密码为："+password);
    }
}
