package com.sf.dao.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "th_sys_perm")
public class ThSysPerm implements Serializable {
    @Id
    @Column(name = "OPER_ID")
    private Long operId;

    /**
     * 操作类型：C-新增操作，D-删除操作，U-修改操作
     */
    @Column(name = "OPER_TYPE")
    private String operType;

    @Column(name = "OPER_TIME")
    private Date operTime;

    @Column(name = "OPER_BY")
    private String operBy;

    /**
     * 权限ID
     */
    @Column(name = "PERM_ID")
    private Long permId;

    /**
     * 权限名称
     */
    @Column(name = "PERM_NAME")
    private String permName;

    /**
     * 权限编码：可以硬编码到代码中做判断
     */
    @Column(name = "PERM_CODE")
    private String permCode;

    /**
     * 权限类型：M-菜单，F-功能权限，D-数据
     */
    @Column(name = "PERM_TYPE")
    private String permType;

    /**
     * 有效标识：0-失效，1-有效
     */
    @Column(name = "VALID_TAG")
    private Boolean validTag;

    /**
     * 备注
     */
    @Column(name = "REMARK")
    private String remark;

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
     * @return OPER_ID
     */
    public Long getOperId() {
        return operId;
    }

    /**
     * @param operId
     */
    public void setOperId(Long operId) {
        this.operId = operId;
    }

    /**
     * 获取操作类型：C-新增操作，D-删除操作，U-修改操作
     *
     * @return OPER_TYPE - 操作类型：C-新增操作，D-删除操作，U-修改操作
     */
    public String getOperType() {
        return operType;
    }

    /**
     * 设置操作类型：C-新增操作，D-删除操作，U-修改操作
     *
     * @param operType 操作类型：C-新增操作，D-删除操作，U-修改操作
     */
    public void setOperType(String operType) {
        this.operType = operType;
    }

    /**
     * @return OPER_TIME
     */
    public Date getOperTime() {
        return operTime;
    }

    /**
     * @param operTime
     */
    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    /**
     * @return OPER_BY
     */
    public String getOperBy() {
        return operBy;
    }

    /**
     * @param operBy
     */
    public void setOperBy(String operBy) {
        this.operBy = operBy;
    }

    /**
     * 获取权限ID
     *
     * @return PERM_ID - 权限ID
     */
    public Long getPermId() {
        return permId;
    }

    /**
     * 设置权限ID
     *
     * @param permId 权限ID
     */
    public void setPermId(Long permId) {
        this.permId = permId;
    }

    /**
     * 获取权限名称
     *
     * @return PERM_NAME - 权限名称
     */
    public String getPermName() {
        return permName;
    }

    /**
     * 设置权限名称
     *
     * @param permName 权限名称
     */
    public void setPermName(String permName) {
        this.permName = permName;
    }

    /**
     * 获取权限编码：可以硬编码到代码中做判断
     *
     * @return PERM_CODE - 权限编码：可以硬编码到代码中做判断
     */
    public String getPermCode() {
        return permCode;
    }

    /**
     * 设置权限编码：可以硬编码到代码中做判断
     *
     * @param permCode 权限编码：可以硬编码到代码中做判断
     */
    public void setPermCode(String permCode) {
        this.permCode = permCode;
    }

    /**
     * 获取权限类型：M-菜单，F-功能权限，D-数据
     *
     * @return PERM_TYPE - 权限类型：M-菜单，F-功能权限，D-数据
     */
    public String getPermType() {
        return permType;
    }

    /**
     * 设置权限类型：M-菜单，F-功能权限，D-数据
     *
     * @param permType 权限类型：M-菜单，F-功能权限，D-数据
     */
    public void setPermType(String permType) {
        this.permType = permType;
    }

    /**
     * 获取有效标识：0-失效，1-有效
     *
     * @return VALID_TAG - 有效标识：0-失效，1-有效
     */
    public Boolean getValidTag() {
        return validTag;
    }

    /**
     * 设置有效标识：0-失效，1-有效
     *
     * @param validTag 有效标识：0-失效，1-有效
     */
    public void setValidTag(Boolean validTag) {
        this.validTag = validTag;
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