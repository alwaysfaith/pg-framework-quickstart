package com.sf.service;

import com.sf.dao.mapper.TfSysUserStateMapper;
import com.sf.dao.mapper.TlSysLoginMapper;
import com.sf.dao.model.TfSysUserState;
import com.sf.dao.model.TlSysLogin;
import com.sf.pg.exception.BusinessException;
import com.sf.pg.security.auth.shiro.PrincipalService;
import com.sf.pg.security.auth.shiro.token.TokenEntity;
import com.sf.pg.security.auth.shiro.token.TokenManager;
import com.sf.pg.util.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author 衷立杰
 * @date 2018/3/27
 */
@Service
@Slf4j
public class LoginService {

    @Autowired
    TfSysUserStateMapper tfSysUserStateMapper;

    @Autowired
    TlSysLoginMapper tlSysLoginMapper;

    @Autowired
    PrincipalService principalService;

    @Autowired
    TokenManager tokenManager;


    public TokenEntity doLogin(String loginName,String inputUserPassword){
        String userId = principalService.queryUserIdByLoginName(loginName);

        String dbUserPassword = principalService.queryUserPasswordById(userId);

        if (dbUserPassword == null || inputUserPassword == null || !principalService.validPassword(inputUserPassword, dbUserPassword)) {
            throw new BusinessException("密码不正确");
        }

        Object currentUser = principalService.getCurrentUserById(userId);

        if (null == currentUser) {
            throw new BusinessException("找不到用户信息");
        }

        TokenEntity tokenEntity = tokenManager.createToken(userId, currentUser);
        return tokenEntity;
    }

    /**
     * 登录后操作
     * @param userId
     */
    @Transactional(rollbackFor = Exception.class)
    public void afterLogin(Long userId) {
        saveUserAction(userId);
        saveLoginLog(userId);
    }

    /**
     * 记录最后状态
     *
     * @param userId
     */
    private void saveUserAction(Long userId) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        String ip = IPUtils.getClientIpAddress(request);
        TfSysUserState sysUserState = new TfSysUserState();
        sysUserState.setUserId(userId);
        sysUserState.setLastLoginIp(ip);
        sysUserState.setLastLoginTime(new Date());
        sysUserState.setUpdateTime(new Date());
        if (null == tfSysUserStateMapper.selectByPrimaryKey(userId)) {
            tfSysUserStateMapper.insertSelective(sysUserState);
        } else {
            tfSysUserStateMapper.updateByPrimaryKeySelective(sysUserState);
        }
    }


    /**
     * 记录登录日志
     *
     * @param userId
     */
    private void saveLoginLog(Long userId) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String ip = IPUtils.getClientIpAddress(request);
        TlSysLogin sysLogin = new TlSysLogin();
        sysLogin.setUserId(userId);
        sysLogin.setLoginIp(ip);
        sysLogin.setLoginTime(new Date());
        sysLogin.setUpdateTime(new Date());
        tlSysLoginMapper.insertSelective(sysLogin);
    }

}
