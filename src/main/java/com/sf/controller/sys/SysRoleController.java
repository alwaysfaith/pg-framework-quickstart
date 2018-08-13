package com.sf.controller.sys;

import com.sf.request.sys.*;
import com.sf.dao.model.TfSysRole;
import com.sf.dao.model.TfSysUserRole;
import com.sf.idworker.generator.IdWorkerInstance;
import com.sf.pg.core.log.define.AccessLogger;
import com.sf.pg.entity.R;
import com.sf.service.sys.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author lijie.zh
 */
@Api(tags = {"系统管理-角色"})
@RestController
@Slf4j
@AccessLogger
@RequestMapping("/sys/role")
public class SysRoleController {

    @Autowired
    private SysRoleService roleService;

    @ApiOperation("新增角色")
    @PostMapping("/add")
    @RequiresPermissions("sys:role:add")
    public R add(SysRoleAddRequest request) {
        TfSysRole tfSysRole = new TfSysRole();
        BeanUtils.copyProperties(request, tfSysRole);
        tfSysRole.setRoleId(IdWorkerInstance.getId());
        tfSysRole.setValidTag(true);
        roleService.addSysRole(tfSysRole);
        return R.success();
    }

    @ApiOperation("修改角色")
    @PostMapping("/update")
    @RequiresPermissions("sys:role:update")
    public R update(SysRoleUpdateRequest request) {
        TfSysRole tfSysRole = new TfSysRole();
        BeanUtils.copyProperties(request, tfSysRole);
        roleService.updateSysRole(tfSysRole);
        return R.success();
    }

    @ApiOperation("删除角色")
    @PostMapping("/del")
    @RequiresPermissions("sys:role:del")
    public R del(SysRoleDelRequest request) {
        for (Long roleId : request.getRoleId()) {
            roleService.delSysRole(roleId);
        }
        return R.success();
    }

    @ApiOperation("分配角色")
    @PostMapping("/assignRole")
    @RequiresPermissions("sys:role:assign")
    public R assignRole(SysRoleAssignRequest request) {
        for (Long userId : request.getUserId()) {
            TfSysUserRole tfSysUserRole = new TfSysUserRole();
            tfSysUserRole.setRoleId(request.getRoleId());
            tfSysUserRole.setUserId(userId);
            roleService.assignUserToRole(tfSysUserRole);
        }
        return R.success();
    }

    @ApiOperation("分配角色-移除用户")
    @PostMapping("/outRole")
    @RequiresPermissions("sys:role:out")
    public R outRole(SysRoleOutRequest request) {
        for (Long userId : request.getUserId()) {
            TfSysUserRole tfSysUserRole = new TfSysUserRole();
            tfSysUserRole.setRoleId(request.getRoleId());
            tfSysUserRole.setUserId(userId);
            roleService.outUserInRole(tfSysUserRole);
        }
        return R.success();
    }
}
