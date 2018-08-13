package com.sf.core.exception;

import com.sf.pg.core.BaseExceptionHandler;
import com.sf.pg.entity.R;
import com.sf.pg.security.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * 全局异常处理类
 *
 * @author lijie.zh
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends BaseExceptionHandler {

    @Autowired
    SecurityProperties bootProperties;

    /**
     * 针对未知异常类获取错误内容
     * @param exception
     * @return
     */
    @Override
    protected R gerUnkownExceptionMessage(Exception exception) {
        //如果启用友好提示，针对未知的不能捕获的异常不显示详细堆栈信息，一般用于生产环境
        if (bootProperties.isEnableFriendlyError()) {
            return R.error("系统错误，请稍后再试！");
        }
        String message = exception.getMessage();
        if (StringUtils.isBlank(message)) {
            message = null != exception.getCause() ? exception.getCause().getMessage() : "未知错误";
        }
        return R.error(message);
    }



}