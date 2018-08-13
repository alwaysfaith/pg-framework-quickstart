package com.sf.service.sys;

import com.sf.dao.mapper.TfSysRoleMapper;
import com.sf.dao.mapper.TfSysUserRoleMapper;
import com.sf.dao.model.TfSysPerm;
import com.sf.dao.model.TfSysRole;
import com.sf.dao.model.TfSysUserRole;
import com.sf.dao.model.ThSysPerm;
import com.sf.pg.constant.OperEnum;
import com.sf.pg.core.mybatis.util.OperUtils;
import com.sf.pg.security.auth.shiro.ShiroCacheHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lijie.zh
 */
@Slf4j
@Service
public class SysRoleService {

    @Autowired
    TfSysRoleMapper tfSysRoleMapper;

    @Autowired
    TfSysUserRoleMapper tfSysUserRoleMapper;

    public void addSysRole(TfSysRole tfSysRole){
        tfSysRoleMapper.insert(tfSysRole);
    }

    public void updateSysRole(TfSysRole tfSysRole){
        tfSysRoleMapper.updateByPrimaryKeySelective(tfSysRole);
        //更新权限缓存
        ShiroCacheHelper.clearAllCachedAuthorizationInfo();
    }

    public void delSysRole(Long roleId){
        tfSysRoleMapper.deleteByPrimaryKey(roleId);
        //更新权限缓存
        ShiroCacheHelper.clearAllCachedAuthorizationInfo();
    }

    public void assignUserToRole(TfSysUserRole tfSysUserRole){
        if (!isExistsUserRole(tfSysUserRole)){
            tfSysUserRoleMapper.insert(tfSysUserRole);
        }
        //更新该用户权限缓存
        ShiroCacheHelper.clearCachedAuthenticationInfo(tfSysUserRole.getUserId());
    }

    public void outUserInRole(TfSysUserRole tfSysUserRole){
        tfSysUserRoleMapper.deleteByPrimaryKey(tfSysUserRole);
        //更新该用户权限缓存
        ShiroCacheHelper.clearCachedAuthenticationInfo(tfSysUserRole.getUserId());
    }

    public Boolean isExistsUserRole(TfSysUserRole tfSysUserRole){
        return  tfSysUserRoleMapper.selectByPrimaryKey(tfSysUserRole) == null ? false : true;
    }

}
