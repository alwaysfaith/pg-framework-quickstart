package com.sf.dao.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tf_sys_user_state")
public class TfSysUserState implements Serializable {
    /**
     * 用户标识
     */
    @Id
    @Column(name = "USER_ID")
    private Long userId;

    /**
     * 上次登录IP
     */
    @Column(name = "LAST_LOGIN_IP")
    private String lastLoginIp;

    /**
     * 上次登录经纬度信息，先经度后维度以英文逗号分割
     */
    @Column(name = "LAST_LOGIN_LOCATION")
    private String lastLoginLocation;

    /**
     * 上次登录时间
     */
    @Column(name = "LAST_LOGIN_TIME")
    private Date lastLoginTime;

    /**
     * 上次使用设备ID
     */
    @Column(name = "LAST_DEVICE_ID")
    private String lastDeviceId;

    /**
     * 创建人
     */
    @Column(name = "CREATE_BY")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 修改人
     */
    @Column(name = "UPDATE_BY")
    private String updateBy;

    /**
     * 修改时间
     */
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取用户标识
     *
     * @return USER_ID - 用户标识
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户标识
     *
     * @param userId 用户标识
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取上次登录IP
     *
     * @return LAST_LOGIN_IP - 上次登录IP
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * 设置上次登录IP
     *
     * @param lastLoginIp 上次登录IP
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    /**
     * 获取上次登录经纬度信息，先经度后维度以英文逗号分割
     *
     * @return LAST_LOGIN_LOCATION - 上次登录经纬度信息，先经度后维度以英文逗号分割
     */
    public String getLastLoginLocation() {
        return lastLoginLocation;
    }

    /**
     * 设置上次登录经纬度信息，先经度后维度以英文逗号分割
     *
     * @param lastLoginLocation 上次登录经纬度信息，先经度后维度以英文逗号分割
     */
    public void setLastLoginLocation(String lastLoginLocation) {
        this.lastLoginLocation = lastLoginLocation;
    }

    /**
     * 获取上次登录时间
     *
     * @return LAST_LOGIN_TIME - 上次登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置上次登录时间
     *
     * @param lastLoginTime 上次登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取上次使用设备ID
     *
     * @return LAST_DEVICE_ID - 上次使用设备ID
     */
    public String getLastDeviceId() {
        return lastDeviceId;
    }

    /**
     * 设置上次使用设备ID
     *
     * @param lastDeviceId 上次使用设备ID
     */
    public void setLastDeviceId(String lastDeviceId) {
        this.lastDeviceId = lastDeviceId;
    }

    /**
     * 获取创建人
     *
     * @return CREATE_BY - 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     *
     * @param createBy 创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改人
     *
     * @return UPDATE_BY - 修改人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置修改人
     *
     * @param updateBy 修改人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取修改时间
     *
     * @return UPDATE_TIME - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}