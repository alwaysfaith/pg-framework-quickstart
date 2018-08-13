package com.sf.core.auth;

import com.sf.dao.mapper.TfSysPermMapper;
import com.sf.dao.mapper.TfSysRoleMapper;
import com.sf.pg.context.ActionHolder;
import com.sf.pg.security.auth.shiro.AuthorizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class CustomAuthorizationService implements AuthorizationService {

    @Autowired
    TfSysRoleMapper tfSysRoleMapper;

    @Autowired
    TfSysPermMapper tfSysPermMapper;

    @Autowired
    ActionHolder actionHolder;

    @Override
    public List<String> selectRoles(String principal) {
        log.info("从数据库获取角色信息");
        List<String> userRoles ;
        if (actionHolder.isSuperUser(principal)) {
            userRoles = tfSysRoleMapper.queryAllRoleKeys();
        } else {
            userRoles = tfSysRoleMapper.queryRoleKeysByUserId(Long.parseLong(principal));
        }
        return userRoles;
    }

    @Override
    public List<String> selectPerms(String principal) {
        log.info("从数据库获取权限信息");
        List<String> perms ;

        if (actionHolder.isSuperUser(principal)) {
            perms = tfSysPermMapper.queryAllPermKeys();
        }else{
            List<String> rolePerms = tfSysPermMapper.queryRolePermKeysByUserId(Long.parseLong(principal));
            List<String> userPerms = tfSysPermMapper.queryUserPermKeysByUserId(Long.parseLong(principal));

            Set<String> set = new HashSet<>();
            set.addAll(rolePerms);
            set.addAll(userPerms);
            perms = new ArrayList<>(set);
        }
        return perms;
    }
}