package com.sf.core.converter;

import com.sf.dao.mapper.TfSysDepartMapper;
import com.sf.dao.mapper.TfSysUserMapper;
import com.sf.dao.model.TfSysDepart;
import com.sf.dao.model.TfSysUser;
import com.sf.pg.core.convert.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * 用户ID转用户名
 * @author lijie.zh
 */
@Component
public class DeptConverter implements Converter {

    @Autowired
    TfSysDepartMapper tfSysDepartMapper;

    @Cacheable(value = "code2name_dept", key = "#deptId", unless="#result == null" )
    @Override
    public Object convert(Object deptId, String indexKey) {
        TfSysDepart tfSysDepart = tfSysDepartMapper.selectByPrimaryKey(deptId);
        if (null == tfSysDepart) {
            return null;
        }
        return tfSysDepart.getDeptName();
    }
}