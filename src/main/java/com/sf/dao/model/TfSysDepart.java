package com.sf.dao.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tf_sys_depart")
public class TfSysDepart implements Serializable {
    /**
     * 部门ID
     */
    @Id
    @Column(name = "DEPT_ID")
    private Long deptId;

    /**
     * 部门名称
     */
    @Column(name = "DEPT_NAME")
    private String deptName;

    /**
     * 上级部门
     */
    @Column(name = "PARENT_DEPT_ID")
    private Long parentDeptId;

    /**
     * 部门层级关系
     */
    @Column(name = "DEPT_FRAME")
    private String deptFrame;

    /**
     * 部门类型：0-实体部门,1-虚拟部门
     */
    @Column(name = "DEPT_TYPE")
    private Integer deptType;

    /**
     * 部门标识：主要用于硬编码判断某一个部门时使用，避免直接使用ID。该列值一般用部门名称的拼音首字母大写。
     */
    @Column(name = "DEPT_TAG")
    private String deptTag;

    /**
     * 部门主管
     */
    @Column(name = "DEPT_MANAGER")
    private Long deptManager;

    /**
     * 省：部门区域信息
     */
    @Column(name = "PROV_ID")
    private String provId;

    /**
     * 市：部门区域信息
     */
    @Column(name = "CITY_ID")
    private String cityId;

    /**
     * 县：部门区域信息
     */
    @Column(name = "AREA_ID")
    private String areaId;

    /**
     * 有效标识：0-无效，1-有效
     */
    @Column(name = "VALID_TAG")
    private Boolean validTag;

    /**
     * 排序
     */
    @Column(name = "SORT_NO")
    private Integer sortNo;

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
     * 获取部门ID
     *
     * @return DEPT_ID - 部门ID
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * 设置部门ID
     *
     * @param deptId 部门ID
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取部门名称
     *
     * @return DEPT_NAME - 部门名称
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置部门名称
     *
     * @param deptName 部门名称
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 获取上级部门
     *
     * @return PARENT_DEPT_ID - 上级部门
     */
    public Long getParentDeptId() {
        return parentDeptId;
    }

    /**
     * 设置上级部门
     *
     * @param parentDeptId 上级部门
     */
    public void setParentDeptId(Long parentDeptId) {
        this.parentDeptId = parentDeptId;
    }

    /**
     * 获取部门层级关系
     *
     * @return DEPT_FRAME - 部门层级关系
     */
    public String getDeptFrame() {
        return deptFrame;
    }

    /**
     * 设置部门层级关系
     *
     * @param deptFrame 部门层级关系
     */
    public void setDeptFrame(String deptFrame) {
        this.deptFrame = deptFrame;
    }

    /**
     * 获取部门类型：0-实体部门,1-虚拟部门
     *
     * @return DEPT_TYPE - 部门类型：0-实体部门,1-虚拟部门
     */
    public Integer getDeptType() {
        return deptType;
    }

    /**
     * 设置部门类型：0-实体部门,1-虚拟部门
     *
     * @param deptType 部门类型：0-实体部门,1-虚拟部门
     */
    public void setDeptType(Integer deptType) {
        this.deptType = deptType;
    }

    /**
     * 获取部门标识：主要用于硬编码判断某一个部门时使用，避免直接使用ID。该列值一般用部门名称的拼音首字母大写。
     *
     * @return DEPT_TAG - 部门标识：主要用于硬编码判断某一个部门时使用，避免直接使用ID。该列值一般用部门名称的拼音首字母大写。
     */
    public String getDeptTag() {
        return deptTag;
    }

    /**
     * 设置部门标识：主要用于硬编码判断某一个部门时使用，避免直接使用ID。该列值一般用部门名称的拼音首字母大写。
     *
     * @param deptTag 部门标识：主要用于硬编码判断某一个部门时使用，避免直接使用ID。该列值一般用部门名称的拼音首字母大写。
     */
    public void setDeptTag(String deptTag) {
        this.deptTag = deptTag;
    }

    /**
     * 获取部门主管
     *
     * @return DEPT_MANAGER - 部门主管
     */
    public Long getDeptManager() {
        return deptManager;
    }

    /**
     * 设置部门主管
     *
     * @param deptManager 部门主管
     */
    public void setDeptManager(Long deptManager) {
        this.deptManager = deptManager;
    }

    /**
     * 获取省：部门区域信息
     *
     * @return PROV_ID - 省：部门区域信息
     */
    public String getProvId() {
        return provId;
    }

    /**
     * 设置省：部门区域信息
     *
     * @param provId 省：部门区域信息
     */
    public void setProvId(String provId) {
        this.provId = provId;
    }

    /**
     * 获取市：部门区域信息
     *
     * @return CITY_ID - 市：部门区域信息
     */
    public String getCityId() {
        return cityId;
    }

    /**
     * 设置市：部门区域信息
     *
     * @param cityId 市：部门区域信息
     */
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    /**
     * 获取县：部门区域信息
     *
     * @return AREA_ID - 县：部门区域信息
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * 设置县：部门区域信息
     *
     * @param areaId 县：部门区域信息
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
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
     * 获取排序
     *
     * @return SORT_NO - 排序
     */
    public Integer getSortNo() {
        return sortNo;
    }

    /**
     * 设置排序
     *
     * @param sortNo 排序
     */
    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
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