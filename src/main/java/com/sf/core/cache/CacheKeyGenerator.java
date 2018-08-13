package com.sf.core.cache;

import com.alibaba.fastjson.JSON;
import com.google.common.hash.Hashing;
import com.sf.pg.aop.AopTargetUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;
import java.nio.charset.Charset;

/**
 * @author lijie.zh
 */
@Slf4j
public class CacheKeyGenerator implements KeyGenerator {
    public static final int NO_PARAM_KEY = 0;
    public static final String NULL_PARAM_KEY = "null";

    @Override
    public Object generate(Object target, Method method, Object... params) {
        try {
            String className = AopTargetUtils.getTarget(target).getClass().getSimpleName();
            StringBuilder key = new StringBuilder();
            key.append(className).append(".").append(method.getName()).append(":");
            if (params.length == 0) {
                key.append(NO_PARAM_KEY).toString();
            }else{
                for (Object param : params) {
                    if (param == null) {
                        key.append(NULL_PARAM_KEY);
                    } else {
                        if (BeanUtils.isSimpleValueType(param.getClass())) {
                            key.append(param);
                        } else {
                            key.append(Hashing.murmur3_128().hashString(JSON.toJSONString(param), Charset.defaultCharset()).asLong());
                        }
                    }
                    key.append("_");
                }
                key = key.deleteCharAt(key.length() - 1);
            }
            return key.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
