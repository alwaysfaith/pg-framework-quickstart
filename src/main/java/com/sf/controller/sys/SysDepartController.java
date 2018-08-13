package com.sf.controller.sys;

import com.sf.dao.model.TfSysDepart;
import com.sf.dao.model.TfSysDict;
import com.sf.pg.constant.ErrorStatusEnum;
import com.sf.pg.core.mybatis.util.ListUtils;
import com.sf.pg.core.mybatis.util.PageHelper;
import com.sf.pg.entity.PageList;
import com.sf.pg.entity.R;
import com.sf.request.sys.SysDictAddRequest;
import com.sf.request.sys.SysDictDelRequest;
import com.sf.request.sys.SysDictQueryRequest;
import com.sf.request.sys.SysDictUpdateRequest;
import com.sf.response.sys.SysDepartTree;
import com.sf.response.sys.SysDict;
import com.sf.service.sys.SysDepartService;
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
import java.util.List;


/**
 * @author lijie.zh
 */
@Api(tags = {"系统管理-部门"})
@RestController
@Slf4j
@RequestMapping("/sys/depart")
public class SysDepartController {

    @Autowired
    SysDepartService sysDepartService;


    @ApiOperation("部门树列表")
    @GetMapping("/tree")
    public R<List<SysDepartTree>> tree() {
        TfSysDepart tfSysDepart = new TfSysDepart();
        tfSysDepart.setValidTag(true);
        List<TfSysDepart> list = sysDepartService.list(tfSysDepart);
        List<SysDepartTree> results = ListUtils.convert(list,SysDepartTree.class);
        return R.success(results);
    }


}
