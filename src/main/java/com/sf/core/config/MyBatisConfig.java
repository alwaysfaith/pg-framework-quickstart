package com.sf.core.config;

import com.sf.pg.core.mybatis.BaseMyBatisConfig;
import com.sf.pg.core.mybatis.interceptor.CommonFieldInterceptor;
import com.sf.pg.core.mybatis.interceptor.SqlLogInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lijie.zh
 */
@Configuration
public class MyBatisConfig extends BaseMyBatisConfig {
    /**
     * 设置通用的CREATE_TIME UPDATE_TIME 信息
     *
     * @return
     */
    @Bean
    public CommonFieldInterceptor getCommonDbInterceptor() {
        return new CommonFieldInterceptor();
    }

    /**
     * 记录SQL执行日志的切面
     * @return
     */
    @Bean
    public SqlLogInterceptor getSqlStatementInterceptor(){
        return new SqlLogInterceptor();
    }
}
