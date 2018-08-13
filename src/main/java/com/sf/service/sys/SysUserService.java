package com.sf.service.sys;

import com.sf.dao.mapper.TfSysUserMapper;
import com.sf.dao.mapper.TfSysUserPasswordMapper;
import com.sf.dao.model.TfSysUser;
import com.sf.dao.model.TfSysUserPassword;
import com.sf.pg.core.mybatis.util.PageHelper;
import com.sf.pg.entity.PageList;
import com.sf.pg.entity.Pagination;
import com.sf.pg.exception.BusinessException;
import com.sf.pg.security.SecurityProperties;
import com.sf.service.UserService;
import com.sf.core.auth.PasswordEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author: lijie.zh
 */
@Slf4j
@Service
public class SysUserService {

    @Autowired
    TfSysUserMapper tfSysUserMapper;

    @Autowired
    TfSysUserPasswordMapper tfSysUserPasswordMapper;

    @Autowired
    SecurityProperties securityProperties;

    @Autowired
    UserService userService;

    public PageList<TfSysUser> list(TfSysUser tfSysUser, Pagination pg) {
        List<TfSysUser> list = tfSysUserMapper.queryList(tfSysUser, PageHelper.createRowBounds(pg));
        return PageHelper.buildPageList(list);
    }

    public TfSysUser get(Long userId) {
        return tfSysUserMapper.selectByPrimaryKey(userId);
    }

    public void del(Long userId) {
        TfSysUser tfSysUser = new TfSysUser();
        tfSysUser.setUserId(userId);
        tfSysUser.setValidTag(false);
        tfSysUserMapper.updateByPrimaryKeySelective(tfSysUser);
    }

    public void update(TfSysUser tfSysUser) {
        if (checkExistsForUpdate(tfSysUser)) {
            throw new BusinessException("用户名、邮箱或手机号码已存在");
        }
        tfSysUserMapper.updateByPrimaryKeySelective(tfSysUser);
    }


    public boolean checkExistsForUpdate(TfSysUser tfSysUser) {
        TfSysUser param = new TfSysUser();
        param.setUserName(tfSysUser.getUserName());
        param.setStaffId(tfSysUser.getStaffId());
        param.setEmail(tfSysUser.getEmail());
        param.setMobileNo(tfSysUser.getMobileNo());

        List<TfSysUser> tfSysUsers = tfSysUserMapper.queryByOrCondition(param);

        for (TfSysUser user : tfSysUsers) {
            if (!user.getUserId().equals(tfSysUser.getUserId())) {
                return true;
            }
        }
        return false;
    }

    @Transactional(rollbackFor = Exception.class)
    public Long add(TfSysUser tfSysUser, TfSysUserPassword tfSysUserPassword) {
        if (userService.isExists(tfSysUser)) {
            throw new BusinessException("用户名、邮箱或手机号码已存在");
        }
        tfSysUserPassword.setPassword(PasswordEncoder.getEncryptedPwd(securityProperties.getDefaultPassword()));
        return userService.register(tfSysUser, tfSysUserPassword);
    }

    @Transactional(rollbackFor = Exception.class)
    public String resetPassword(Long userId) {
        String defaultPassword = securityProperties.getDefaultPassword();
        TfSysUserPassword tfSysUserPassword = new TfSysUserPassword();
        tfSysUserPassword.setUserId(userId);
        tfSysUserPassword.setPassword(PasswordEncoder.getEncryptedPwd(defaultPassword));
        tfSysUserPassword.setLastUpdateTime(new Date());
        tfSysUserPasswordMapper.updateByPrimaryKeySelective(tfSysUserPassword);
        return defaultPassword;
    }
}