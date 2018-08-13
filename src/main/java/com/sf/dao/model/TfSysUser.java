package com.sf.dao.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tf_sys_user")
public class TfSysUser implements Serializable {
    /**
     * 用户标识
     */
    @Id
    @Column(name = "USER_ID")
    private Long userId;

    /**
     * 用户名称
     */
    @Column(name = "USER_NAME")
    private String userName;

    /**
     * 工号
     */
    @Column(name = "STAFF_ID")
    private String staffId;

    /**
     * 手机号码
     */
    @Column(name = "MOBILE_NO")
    private String mobileNo;

    /**
     * 性别：M-男，W-女
     */
    @Column(name = "SEX")
    private String sex;

    /**
     * 头像URL
     */
    @Column(name = "AVATAR")
    private String avatar;

    /**
     * 邮箱
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * 用户所属部门
     */
    @Column(name = "DEPT_ID")
    private Long deptId;

    /**
     * 有效状态：1-有效，0-无效
     */
    @Column(name = "VALID_TAG")
    private Boolean validTag;

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
     * 获取用户名称
     *
     * @return USER_NAME - 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名称
     *
     * @param userName 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取工号
     *
     * @return STAFF_ID - 工号
     */
    public String getStaffId() {
        return staffId;
    }

    /**
     * 设置工号
     *
     * @param staffId 工号
     */
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    /**
     * 获取手机号码
     *
     * @return MOBILE_NO - 手机号码
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * 设置手机号码
     *
     * @param mobileNo 手机号码
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * 获取性别：M-男，W-女
     *
     * @return SEX - 性别：M-男，W-女
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别：M-男，W-女
     *
     * @param sex 性别：M-男，W-女
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取头像URL
     *
     * @return AVATAR - 头像URL
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像URL
     *
     * @param avatar 头像URL
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取邮箱
     *
     * @return EMAIL - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取用户所属部门
     *
     * @return DEPT_ID - 用户所属部门
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * 设置用户所属部门
     *
     * @param deptId 用户所属部门
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取有效状态：1-有效，0-无效
     *
     * @return VALID_TAG - 有效状态：1-有效，0-无效
     */
    public Boolean getValidTag() {
        return validTag;
    }

    /**
     * 设置有效状态：1-有效，0-无效
     *
     * @param validTag 有效状态：1-有效，0-无效
     */
    public void setValidTag(Boolean validTag) {
        this.validTag = validTag;
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