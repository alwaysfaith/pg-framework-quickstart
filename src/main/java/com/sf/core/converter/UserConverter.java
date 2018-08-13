package com.sf.core.converter;

import com.sf.dao.mapper.TfSysUserMapper;
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
public class UserConverter implements Converter {

    @Autowired
    TfSysUserMapper tfSysUserMapper;

    @Cacheable(value = "code2name_user", key = "#userId", unless="#result == null" )
    @Override
    public Object convert(Object userId, String indexKey) {
        TfSysUser tfSysUser = tfSysUserMapper.selectByPrimaryKey(userId);
        if (null == tfSysUser) {
            return null;
        }
        return tfSysUser.getUserName();
    }
}