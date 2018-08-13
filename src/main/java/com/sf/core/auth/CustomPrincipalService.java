package com.sf.core.auth;

import com.sf.dao.mapper.TfSysUserMapper;
import com.sf.dao.mapper.TfSysUserPasswordMapper;
import com.sf.dao.mapper.TfSysUserStateMapper;
import com.sf.dao.model.TfSysUser;
import com.sf.dao.model.TfSysUserPassword;
import com.sf.dao.model.TfSysUserState;
import com.sf.response.CurrentUser;
import com.sf.pg.exception.BusinessException;
import com.sf.pg.security.auth.shiro.PrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author lijie.zh
 */
@Service
public class CustomPrincipalService implements PrincipalService {

    @Autowired
    TfSysUserMapper tfSysUserMapper;

    @Autowired
    TfSysUserStateMapper tfSysUserStateMapper;

    @Autowired
    TfSysUserPasswordMapper tfSysUserPasswordMapper;

    @Override
    public String queryUserIdByLoginName(String loginName) {
        TfSysUser sysUser = tfSysUserMapper.queryUserByLoginName(loginName);
        if (null == sysUser) {
            throw new BusinessException("用户不存在");
        }
        return sysUser.getUserId().toString();
    }

    @Override
    public Object getCurrentUserById(String userId) {
        TfSysUser sysUser = tfSysUserMapper.selectByPrimaryKey(userId);
        if (null == sysUser) {
            throw new BusinessException("用户不存在");
        }

        TfSysUserState SysUserState = tfSysUserStateMapper.selectByPrimaryKey(sysUser.getUserId());
        CurrentUser currentUser = new CurrentUser();
        currentUser.setUserId(sysUser.getUserId());
        currentUser.setMobileNo(sysUser.getMobileNo());
        currentUser.setUserName(sysUser.getUserName());
        currentUser.setSex(sysUser.getSex());

        if (null != SysUserState && null != SysUserState.getLastLoginIp()) {
            currentUser.setLastLoginIp(SysUserState.getLastLoginIp());
        }
        if (null != SysUserState && null != SysUserState.getLastLoginTime()) {
            currentUser.setLastLoginTime(SysUserState.getLastLoginTime());
        }
        return currentUser;
    }

    @Override
    public String queryUserPasswordById(String userId) {
        TfSysUserPassword sysUserPassword = tfSysUserPasswordMapper.selectByPrimaryKey(userId);
        if (null == sysUserPassword || StringUtils.isEmpty(sysUserPassword.getPassword())) {
            return null;
        }
        return sysUserPassword.getPassword();
    }

    @Override
    public String encryptPassword(String password) {
        return PasswordEncoder.getEncryptedPwd(password);
    }

    @Override
    public Boolean validPassword(String inputPassword, String passwordInDb) {
        return PasswordEncoder.validPassword(inputPassword, passwordInDb);
    }
}
