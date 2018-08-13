package com.sf.dao.mapper;

import com.sf.dao.model.TfSysUser;
import com.sf.core.mapper.MyMapper;
import org.apache.ibatis.session.RowBounds;
import springfox.documentation.annotations.Cacheable;

import java.util.List;

public interface TfSysUserMapper extends MyMapper<TfSysUser> {
    TfSysUser queryUserByLoginName(String loginName);

    List<TfSysUser> queryByOrCondition(TfSysUser sysUser);


    /**
     * @param tfSysUser
     * @param rowBounds
     * @return
     */
    List<TfSysUser> queryList(TfSysUser tfSysUser, RowBounds rowBounds);


}