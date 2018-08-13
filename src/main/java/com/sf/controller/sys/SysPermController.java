package com.sf.controller.sys;

import com.sf.response.sys.SysPerm;
import com.sf.request.sys.*;
import com.sf.dao.model.TfSysPerm;
import com.sf.dao.model.TfSysUserPerm;
import com.sf.pg.core.log.define.AccessLogger;
import com.sf.pg.core.mybatis.util.PageHelper;
import com.sf.pg.entity.PageList;
import com.sf.pg.entity.R;
import com.sf.pg.exception.BusinessException;
import com.sf.service.sys.SysPermService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * @author lijie.zh
 */
@Api(tags = {"系统管理-权限"})
@RestController
@Slf4j
@RequestMapping("/sys/perm")
@Validated
public class SysPermController {

    @Autowired
    private SysPermService sysPermService;

    @ApiOperation("权限列表")
    @GetMapping("/list")
    @RequiresPermissions("sys:perm:list")
    public R<PageList<SysPerm>> list(SysPermQueryRequest request) {
        TfSysPerm tfSysPerm = new TfSysPerm();
        BeanUtils.copyProperties(request, tfSysPerm);
        PageList<TfSysPerm> list = sysPermService.list(tfSysPerm, request.getPagination());
        return R.success(PageHelper.convert(list, SysPerm.class));
    }

    @ApiOperation("新增权限")
    @PostMapping("/add")
    @RequiresPermissions("sys:perm:add")
    public R add(SysPermAddRequest request) {
        if (sysPermService.checkExistsPermCodeForAdd(request.getPermCode())) {
            throw new BusinessException("权限编码已存在");
        }
        TfSysPerm tfSysPerm = new TfSysPerm();
        BeanUtils.copyProperties(request, tfSysPerm);
        tfSysPerm.setValidTag(true);
        sysPermService.addSysPerm(tfSysPerm);
        return R.success();
    }

    @ApiOperation("修改权限")
    @AccessLogger
    @PostMapping("/update")
    @RequiresPermissions("sys:perm:update")
    public R update(SysPermUpdateRequest request) {
        TfSysPerm tfSysPerm = new TfSysPerm();

        if (sysPermService.checkExistsPermCodeForUpdate(request.getPermCode(), request.getPermId())) {
            throw new BusinessException("权限编码已存在");
        }
        BeanUtils.copyProperties(request, tfSysPerm);
        tfSysPerm.setPermId(request.getPermId());
        tfSysPerm.setValidTag(true);
        sysPermService.updateSysPerm(tfSysPerm);
        return R.success();
    }

    @ApiOperation("权限详情")
    @ApiImplicitParam(name = "permId", value = "权限ID", required = true)
    @GetMapping("/get")
    @RequiresPermissions("sys:perm:get")
    public R<SysPerm> get(@NotNull(message = "权限ID不能为空") Long permId) {
        TfSysPerm tfSysPerm = sysPermService.get(permId);
        if (tfSysPerm == null) {
            return R.error("资料不存在");
        }
        SysPerm sysPerm = new SysPerm();
        BeanUtils.copyProperties(tfSysPerm, sysPerm);
        return R.success(sysPerm);
    }

    @ApiOperation("删除权限")
    @ApiImplicitParam(name = "permId", value = "权限ID", required = true)
    @PostMapping("/del")
    @RequiresPermissions("sys:perm:del")
    public R del(@NotNull(message = "权限ID不能为空") Long[] permId) {
        for (Long id : permId) {
            sysPermService.del(id);
        }
        return R.success();
    }

    @ApiOperation("分配权限")
    @PostMapping("/assignPerm")
    @RequiresPermissions("sys:perm:assignuser")
    public R assignPerm(SysPermAssignRequest request) {
        for (Long userId : request.getUserId()) {
            TfSysUserPerm tfSysUserPerm = new TfSysUserPerm();
            tfSysUserPerm.setPermId(request.getPermId());
            tfSysUserPerm.setUserId(userId);
            sysPermService.assignUserToPerm(tfSysUserPerm);
        }
        return R.success();
    }

    @ApiOperation("分配权限-移除用户")
    @AccessLogger
    @PostMapping("/outPerm")
    @RequiresPermissions("sys:perm:outuser")
    public R outPerm(SysPermOutRequest request) {
        for (Long userId : request.getUserId()) {
            TfSysUserPerm tfSysUserPerm = new TfSysUserPerm();
            tfSysUserPerm.setPermId(request.getPermId());
            tfSysUserPerm.setUserId(userId);
            sysPermService.outUserInPerm(tfSysUserPerm);
        }
        return R.success();
    }
}

