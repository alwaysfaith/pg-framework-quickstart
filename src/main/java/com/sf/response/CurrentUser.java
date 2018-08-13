package com.sf.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 当前用户实体类，可以从当前会话中获取到
 * @author lijie.zh
 */
@Getter
@Setter
public class CurrentUser implements Serializable{

    Long userId;

    String userName;

    String mobileNo;

    private String email;

    private String sex;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;

    private String lastLoginIp;

}
