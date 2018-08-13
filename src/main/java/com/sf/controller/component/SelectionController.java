package com.sf.controller.component;

import com.sf.response.component.Selection;
import com.sf.dao.model.TfSysDict;
import com.sf.pg.entity.R;
import com.sf.service.sys.SysDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

/**
 * 选择项组件
 *
 * @author: lijie.zh
 */
@Api(tags = {"选择项组件"})
@Slf4j
@RestController
@RequestMapping("component/selection")
@Validated
public class SelectionController {

    @Autowired
    SysDictService sysDictService;

    @ApiOperation("字典选择项")
    @ApiImplicitParam(name = "dictKey", value = "字典key", required = true)
    @GetMapping("/dict")
    public R<List<Selection>> dict(@NotEmpty String dictKey) {
        List<TfSysDict> list = sysDictService.listByKey(dictKey);
        List<Selection> selections = new ArrayList<>();
        list.stream().forEach(tfSysDict -> {
            Selection selection = new Selection();
            selection.setText(tfSysDict.getDictText());
            selection.setValue(tfSysDict.getDictValue());
            selections.add(selection);
        });
        return R.success(selections);
    }
}
