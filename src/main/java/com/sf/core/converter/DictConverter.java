package com.sf.core.converter;

import com.sf.dao.mapper.TfSysDictMapper;
import com.sf.dao.model.TfSysDict;
import com.sf.pg.core.convert.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.util.StringUtil;

/**
 * 字典code转text
 *
 * @author lijie.zh
 */
@Component
public class DictConverter implements Converter {

    @Autowired
    TfSysDictMapper tfSysDictMapper;

    @Cacheable(value = "code2name_dict", key = "#dictKey+'_'+#dictValue", unless = "#result == null")
    @Override
    public Object convert(Object dictValue, String dictKey) {
        if (StringUtil.isEmpty(dictKey) || StringUtils.isEmpty(dictValue)) {
            return null;
        }
        //数据库中对boolean类型存储的是0和1
        if (dictValue instanceof Boolean) {
            dictValue = ((Boolean) dictValue).booleanValue() ? 1 : 0;
        }

        TfSysDict param = new TfSysDict();
        param.setDictKey(dictKey);
        param.setDictValue(dictValue.toString());
        param.setValidTag(true);
        TfSysDict tfSysDict = tfSysDictMapper.selectOne(param);

        if (tfSysDict == null) {
            return null;
        }
        return tfSysDict.getDictText();
    }
}