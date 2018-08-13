package com.sf.dao.mapper;

import com.sf.dao.model.TfSysPerm;
import com.sf.core.mapper.MyMapper;
import com.sf.pg.security.auth.shiro.ResUrl;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TfSysPermMapper extends MyMapper<TfSysPerm> {

    List<String> queryAllPermKeys();

    /**
     * 获取分配到个人的角色里的权限代码
     *
     * @param userId
     * @return
     */
    List<String> queryRolePermKeysByUserId(Long userId);

    /**
     * 获取分配到个人身上的权限代码
     *
     * @param userId
     * @return
     */
    List<String> queryUserPermKeysByUserId(Long userId);

    /**
     * @param tfSysPerm
     * @param rowBounds
     * @return
     */
    List<TfSysPerm> queryList(TfSysPerm tfSysPerm, RowBounds rowBounds);


    /**
     * 获取所有的需要鉴权的url
     * @return
     */
    List<ResUrl> queryResUrl();

}