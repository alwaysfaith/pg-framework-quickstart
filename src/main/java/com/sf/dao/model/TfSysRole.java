package com.sf.dao.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tf_sys_role")
public class TfSysRole implements Serializable {
    /**
     * 角色ID
     */
    @Id
    @Column(name = "ROLE_ID")
    private Long roleId;

    /**
     * 角色名称
     */
    @Column(name = "ROLE_NAME")
    private String roleName;

    /**
     * 角色编码
     */
    @Column(name = "ROLE_CODE")
    private String roleCode;

    /**
     * 角色类型:0-部门角色,仅限于给本部门下的人员分配该角色,与部门角色表关联；1-全局角色,所有的人都可以分配该角色
     */
    @Column(name = "ROLE_TYPE")
    private String roleType;

    /**
     * 备注
     */
    @Column(name = "REMARK")
    private String remark;

    /**
     * 有效标识：0-无效，1-有效
     */
    @Column(name = "VALID_TAG")
    private Boolean validTag;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 创建人
     */
    @Column(name = "CREATE_BY")
    private String createBy;

    /**
     * 更新时间
     */
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 更新人
     */
    @Column(name = "UPDATE_BY")
    private String updateBy;

    private static final long serialVersionUID = 1L;

    /**
     * 获取角色ID
     *
     * @return ROLE_ID - 角色ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色ID
     *
     * @param roleId 角色ID
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取角色名称
     *
     * @return ROLE_NAME - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取角色编码
     *
     * @return ROLE_CODE - 角色编码
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * 设置角色编码
     *
     * @param roleCode 角色编码
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    /**
     * 获取角色类型:0-部门角色,仅限于给本部门下的人员分配该角色,与部门角色表关联；1-全局角色,所有的人都可以分配该角色
     *
     * @return ROLE_TYPE - 角色类型:0-部门角色,仅限于给本部门下的人员分配该角色,与部门角色表关联；1-全局角色,所有的人都可以分配该角色
     */
    public String getRoleType() {
        return roleType;
    }

    /**
     * 设置角色类型:0-部门角色,仅限于给本部门下的人员分配该角色,与部门角色表关联；1-全局角色,所有的人都可以分配该角色
     *
     * @param roleType 角色类型:0-部门角色,仅限于给本部门下的人员分配该角色,与部门角色表关联；1-全局角色,所有的人都可以分配该角色
     */
    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    /**
     * 获取备注
     *
     * @return REMARK - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取有效标识：0-无效，1-有效
     *
     * @return VALID_TAG - 有效标识：0-无效，1-有效
     */
    public Boolean getValidTag() {
        return validTag;
    }

    /**
     * 设置有效标识：0-无效，1-有效
     *
     * @param validTag 有效标识：0-无效，1-有效
     */
    public void setValidTag(Boolean validTag) {
        this.validTag = validTag;
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
     * 获取更新时间
     *
     * @return UPDATE_TIME - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取更新人
     *
     * @return UPDATE_BY - 更新人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新人
     *
     * @param updateBy 更新人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}