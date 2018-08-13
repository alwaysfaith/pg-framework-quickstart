package com.sf.controller.sys;

import com.sf.dao.model.TfSysDict;
import com.sf.pg.constant.ErrorStatusEnum;
import com.sf.pg.core.mybatis.util.PageHelper;
import com.sf.pg.entity.PageList;
import com.sf.pg.entity.R;
import com.sf.request.sys.SysDictAddRequest;
import com.sf.request.sys.SysDictDelRequest;
import com.sf.request.sys.SysDictQueryRequest;
import com.sf.request.sys.SysDictUpdateRequest;
import com.sf.response.sys.SysDict;
import com.sf.service.sys.SysDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;


/**
 * @author lijie.zh
 */
@Api(tags = {"系统管理-字典"})
@RestController
@Slf4j
@RequestMapping("/sys/dict")
public class SysDictController {

    @Autowired
    private SysDictService sysDictService;


    @ApiOperation("字典详情")
    @GetMapping("/get")
    @RequiresPermissions("sys:dict:get")
    public R<SysDict> list(@NotNull Long dictId) {
        TfSysDict tfSysDict = sysDictService.get(dictId);
        if (null == tfSysDict) {
            return R.error(ErrorStatusEnum.DATA_NOTFUND.getText());
        }
        SysDict sysDict = new SysDict();
        BeanUtils.copyProperties(tfSysDict, sysDict);
        return R.success(sysDict);
    }


    @ApiOperation("字典列表")
    @GetMapping("/list")
    @RequiresPermissions("sys:dict:list")
    public R<PageList<SysDict>> list(SysDictQueryRequest request) {
        TfSysDict tfSysDict = new TfSysDict();
        BeanUtils.copyProperties(request, tfSysDict);
        PageList<TfSysDict> list = sysDictService.list(tfSysDict, request.getPagination());
        PageList<SysDict> results = PageHelper.convert(list, SysDict.class);
        return R.success(results);
    }

    @ApiOperation("新增字典")
    @PostMapping("/add")
    @RequiresPermissions("sys:dict:add")
    public R add(SysDictAddRequest request) {
        TfSysDict tfSysDict = new TfSysDict();
        BeanUtils.copyProperties(request, tfSysDict);
        tfSysDict.setValidTag(true);
        sysDictService.add(tfSysDict);
        return R.success("添加成功");
    }

    @ApiOperation("修改字典")
    @PostMapping("/update")
    @RequiresPermissions("sys:dict:update")
    public R update(SysDictUpdateRequest request) {
        TfSysDict tfSysDict = new TfSysDict();
        BeanUtils.copyProperties(request, tfSysDict);
        sysDictService.update(tfSysDict);
        return R.success("修改成功");
    }

    @ApiOperation("删除字典")
    @PostMapping("/del")
    @RequiresPermissions("sys:dict:del")
    public R del(SysDictDelRequest request) {
        for (Long dictId : request.getDictId()) {
            TfSysDict tfSysDict = sysDictService.get(dictId);
            if (tfSysDict != null) {
                //为了清缓存
                tfSysDict.setDictKey(sysDictService.get(dictId).getDictKey());
                sysDictService.del(tfSysDict);
            }
        }
        return R.success("删除成功");
    }

}
