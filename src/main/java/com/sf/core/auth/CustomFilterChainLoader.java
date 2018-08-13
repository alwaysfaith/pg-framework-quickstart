package com.sf.core.auth;

import com.sf.dao.mapper.TfSysPermMapper;
import com.sf.dao.model.TfSysMenu;
import com.sf.pg.security.auth.shiro.FilterChainLoader;
import com.sf.pg.security.auth.shiro.ResUrl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Shiro过滤器链构造器
 * @author: lijie.zh
 */
@Component
public class CustomFilterChainLoader implements FilterChainLoader {

    @Autowired
    TfSysPermMapper tfSysPermapper;

    /**
     * 构造过滤器链
     * 1， 相同url规则，后面定义的会覆盖前面定义的(执行的时候只执行最后一个)。
     * 2， 两个url规则都可以匹配同一个url，只执行第一个
     * @return
     */
    @Override
    public LinkedHashMap<String,String> bulidFilterChainMap(){
        LinkedHashMap<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/login","anon");
        filterChainDefinitionMap.put("/register","anon");
        filterChainDefinitionMap.put("/swagger*/**","anon");
        filterChainDefinitionMap.put("/webjars/**","anon");
        filterChainDefinitionMap.put("/v2/api-docs/**","anon");
        filterChainDefinitionMap.put("/logout","logout");
        filterChainDefinitionMap.put("/doc*","anon");

        initPermChain(filterChainDefinitionMap);

        filterChainDefinitionMap.put("/**","authc");
        return filterChainDefinitionMap;
    }

    private void initPermChain(Map<String,String> filterChainDefinitionMap){
        TfSysMenu query = new TfSysMenu();
        query.setValidTag(true);
        List<ResUrl> resUrls = tfSysPermapper.queryResUrl();

        resUrls.forEach(resUrl -> {
            if (!StringUtils.isEmpty(resUrl.getUrl()) && !StringUtils.isEmpty(resUrl.getPermKey())) {
                //同一个url可能会对应多个权限码，有其中任意一个就能访问
                String[] permKeyArray = resUrl.getPermKey().split(",");
                if(permKeyArray.length > 1){
                    String format = "anyPerms[{0}]";
                    StringBuilder tmp = new StringBuilder();
                    for (String permKey : permKeyArray) {

                        tmp.append("\"");
                        tmp.append(permKey.trim());
                        tmp.append("\"");
                        tmp.append(",");
                    }
                    tmp = tmp.deleteCharAt(tmp.length() - 1);

                    StringBuilder permKeys = new StringBuilder();
                    permKeys.append(MessageFormat.format(format, tmp));
                    permKeys = permKeys.deleteCharAt(permKeys.length() - 1);
                    permKeys.insert(0,"authc,");
                    filterChainDefinitionMap.put(resUrl.getUrl(), permKeys.toString());
                }else{
                    StringBuilder permKey = new StringBuilder();
                    String format = "perms[\"{0}\"]";
                    permKey.append(MessageFormat.format(format, permKeyArray[0].trim()));
                    permKey.insert(0,"authc,");
                    filterChainDefinitionMap.put(resUrl.getUrl(), permKey.toString());
                }
            }
        });
    }

}
