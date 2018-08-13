package com.sf.core.context;

import com.sf.pg.context.ActionHolder;
import com.sf.response.CurrentUser;
import com.sf.pg.constant.ErrorStatusEnum;
import com.sf.pg.exception.BusinessException;
import com.sf.pg.security.auth.shiro.AuthUtils;
import com.sf.pg.security.auth.shiro.token.TokenEntity;
import com.sf.pg.security.auth.shiro.token.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户工具类
 *
 * @author lijie.zh
 */
@Component
public class DefaultActionHolder implements ActionHolder {

    @Autowired
    public TokenManager tokenManager;

    @Override
    public Boolean isSuperUser(String userId) {
        if ("100000".equals(userId)) {
            return true;
        }
        return false;
    }


    /**
     * 获取登录用户的上下文
     *
     * @return
     */
    @Override
    public CurrentUser getContext() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        String userId = AuthUtils.getUserIdFromRequest(request);
        String tokenId = AuthUtils.getTokenIdFromRequest(request);

        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(tokenId)) {
            throw new BusinessException(ErrorStatusEnum.INVALID_SESSION.getValue(), ErrorStatusEnum.INVALID_SESSION.getText());
        }

        TokenEntity tokenEntity = tokenManager.getToken(userId, tokenId);
        return (CurrentUser) tokenEntity.getContext();
    }


    @Override
    public Long getUserId() {
        Long userId;
        try {
            userId = getContext().getUserId();
        } catch (Exception e) {
            return null;
        }
        return userId;
    }
}