package com.sf.service;

import com.sf.dao.mapper.TfSysUserMapper;
import com.sf.dao.mapper.TfSysUserPasswordMapper;
import com.sf.dao.model.TfSysUser;
import com.sf.dao.model.TfSysUserPassword;
import com.sf.idworker.generator.IdWorkerInstance;
import com.sf.pg.exception.BusinessException;
import com.sf.core.auth.PasswordEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lijie.zh
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    TfSysUserMapper tfSysUserMapper;

    @Autowired
    TfSysUserPasswordMapper tfSysUserPasswordMapper;

    /**
     * 注册一个新用户
     *
     * @param tfSysUser
     * @param sysUserPassword
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Long register(TfSysUser tfSysUser, TfSysUserPassword sysUserPassword) {
        if (isExists(tfSysUser)) {
            throw new BusinessException("用户名、邮箱或手机号码已存在");
        }

        Long userId = IdWorkerInstance.getId();
        tfSysUser.setUserId(userId);
        tfSysUser.setValidTag(true);
        tfSysUserMapper.insert(tfSysUser);

        sysUserPassword.setUserId(userId);
        tfSysUserPasswordMapper.insert(sysUserPassword);
        return userId;
    }

    public boolean isExists(TfSysUser tfSysUser) {
        List<TfSysUser> tfSysUsers = tfSysUserMapper.queryByOrCondition(tfSysUser);
        if (tfSysUsers.size() > 0) {
            return true;
        }
        return false;
    }


    public TfSysUser queryUserByUserId(Long userId) {
        return tfSysUserMapper.selectByPrimaryKey(userId);
    }

    public void updatePassword(Long userId, String newPassword) {
        TfSysUserPassword tfSysUserPassword = new TfSysUserPassword();
        tfSysUserPassword.setUserId(userId);
        tfSysUserPassword.setPassword(PasswordEncoder.getEncryptedPwd(newPassword));
        tfSysUserPasswordMapper.updateByPrimaryKey(tfSysUserPassword);
    }

    public boolean checkPassword(Long userId, String oldPassword) {
        TfSysUserPassword tfSysUserPassword = tfSysUserPasswordMapper.selectByPrimaryKey(userId);
        String passwordInDB = tfSysUserPassword.getPassword();
        return PasswordEncoder.validPassword(oldPassword, passwordInDB);
    }
}
