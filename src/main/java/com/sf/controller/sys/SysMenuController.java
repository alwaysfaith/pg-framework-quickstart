package com.sf.controller.sys;

import com.sf.request.sys.SysMenuAddRequest;
import com.sf.request.sys.SysMenuDelRequest;
import com.sf.request.sys.SysMenuUpdateRequest;
import com.sf.dao.model.TfSysMenu;
import com.sf.idworker.generator.IdWorkerInstance;
import com.sf.pg.core.log.define.AccessLogger;
import com.sf.pg.entity.R;
import com.sf.service.sys.SysMenuService;
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
@Api(tags = {"系统管理-菜单"})
@RestController
@Slf4j
@RequestMapping("/sys/menu")
public class SysMenuController {

    @Autowired
    private SysMenuService menuService;

    @ApiOperation("新增菜单")
    @PostMapping("/add")
    @RequiresPermissions("sys:menu:add")
    public R add(SysMenuAddRequest request) {
        TfSysMenu tfSysMenu = new TfSysMenu();
        BeanUtils.copyProperties(request, tfSysMenu);
        tfSysMenu.setMenuId(IdWorkerInstance.getId());
        tfSysMenu.setValidTag(true);
        menuService.addSysMenu(tfSysMenu);
        return R.success();
    }

    @ApiOperation("修改菜单")
    @PostMapping("/update")
    @RequiresPermissions("sys:menu:update")
    public R update(SysMenuUpdateRequest request) {
        TfSysMenu tfSysMenu = new TfSysMenu();
        BeanUtils.copyProperties(request, tfSysMenu);
        tfSysMenu.setMenuId(request.getMenuId());
        menuService.updateSysMenu(tfSysMenu);
        return R.success();
    }

    @ApiOperation("删除菜单")
    @PostMapping("/del")
    @RequiresPermissions("sys:menu:del")
    public R del(SysMenuDelRequest request) {
        for (Long menuId : request.getMenuId()) {
            menuService.delSysMenu(menuId);
        }
        return R.success();
    }

}
