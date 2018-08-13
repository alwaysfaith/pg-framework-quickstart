package com.sf.dao.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "th_sys_menu")
public class ThSysMenu implements Serializable {
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
     * 菜单ID
     */
    @Column(name = "MENU_ID")
    private Long menuId;

    /**
     * 上级菜单ID
     */
    @Column(name = "PARENT_MENU_ID")
    private Long parentMenuId;

    /**
     * 菜单名称
     */
    @Column(name = "MENU_NAME")
    private String menuName;

    /**
     * 菜单文字说明
     */
    @Column(name = "MENU_DESC")
    private String menuDesc;

    /**
     * url前缀：例如，http://www.xxx.com, 前缀+上下文+url共同组成菜单的详细地址
     */
    @Column(name = "URL_PERFIX")
    private String urlPerfix;

    /**
     * 模块上下文：例如 /crm
     */
    @Column(name = "MOD_CONTEXT")
    private String modContext;

    /**
     * 菜单资源地址：例如/sys/user/get?init=true
     */
    @Column(name = "MENU_URL")
    private String menuUrl;

    /**
     * 权限ID：默认和菜单ID一致
     */
    @Column(name = "PERM_ID")
    private Long permId;

    /**
     * 图标索引
     */
    @Column(name = "ICON_INDEX")
    private String iconIndex;

    /**
     * 资源所属系统编码：资源属于哪个系统，默认DEF
     */
    @Column(name = "RES_OWNER")
    private String resOwner;

    /**
     * 打开方式：0-直接打开，1-新窗口
     */
    @Column(name = "OPEN_TYPE")
    private String openType;

    /**
     * 排序号
     */
    @Column(name = "SORT_NO")
    private Long sortNo;

    /**
     * 菜单设置：可以额外给菜单设置一些属性，JSON格式，{closeSideBar:true,isDefault:true}
     */
    @Column(name = "MENU_CONFIG")
    private String menuConfig;

    /**
     * 层级关系：以英文逗号分割
     */
    @Column(name = "MENU_FRAME")
    private String menuFrame;

    /**
     * 备注
     */
    @Column(name = "REMARK")
    private String remark;

    /**
     * 菜单是否维护中
     */
    @Column(name = "BREAK_TAG")
    private Boolean breakTag;

    /**
     * 有效标识：0-失效，1-有效
     */
    @Column(name = "VALID_TAG")
    private Boolean validTag;

    /**
     * 所属子系统编码：CRM,ERP,BI等
     */
    @Column(name = "SUBSYS_CODE")
    private String subsysCode;

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
     * 获取菜单ID
     *
     * @return MENU_ID - 菜单ID
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * 设置菜单ID
     *
     * @param menuId 菜单ID
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    /**
     * 获取上级菜单ID
     *
     * @return PARENT_MENU_ID - 上级菜单ID
     */
    public Long getParentMenuId() {
        return parentMenuId;
    }

    /**
     * 设置上级菜单ID
     *
     * @param parentMenuId 上级菜单ID
     */
    public void setParentMenuId(Long parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    /**
     * 获取菜单名称
     *
     * @return MENU_NAME - 菜单名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置菜单名称
     *
     * @param menuName 菜单名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * 获取菜单文字说明
     *
     * @return MENU_DESC - 菜单文字说明
     */
    public String getMenuDesc() {
        return menuDesc;
    }

    /**
     * 设置菜单文字说明
     *
     * @param menuDesc 菜单文字说明
     */
    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    /**
     * 获取url前缀：例如，http://www.xxx.com, 前缀+上下文+url共同组成菜单的详细地址
     *
     * @return URL_PERFIX - url前缀：例如，http://www.xxx.com, 前缀+上下文+url共同组成菜单的详细地址
     */
    public String getUrlPerfix() {
        return urlPerfix;
    }

    /**
     * 设置url前缀：例如，http://www.xxx.com, 前缀+上下文+url共同组成菜单的详细地址
     *
     * @param urlPerfix url前缀：例如，http://www.xxx.com, 前缀+上下文+url共同组成菜单的详细地址
     */
    public void setUrlPerfix(String urlPerfix) {
        this.urlPerfix = urlPerfix;
    }

    /**
     * 获取模块上下文：例如 /crm
     *
     * @return MOD_CONTEXT - 模块上下文：例如 /crm
     */
    public String getModContext() {
        return modContext;
    }

    /**
     * 设置模块上下文：例如 /crm
     *
     * @param modContext 模块上下文：例如 /crm
     */
    public void setModContext(String modContext) {
        this.modContext = modContext;
    }

    /**
     * 获取菜单资源地址：例如/sys/user/get?init=true
     *
     * @return MENU_URL - 菜单资源地址：例如/sys/user/get?init=true
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * 设置菜单资源地址：例如/sys/user/get?init=true
     *
     * @param menuUrl 菜单资源地址：例如/sys/user/get?init=true
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    /**
     * 获取权限ID：默认和菜单ID一致
     *
     * @return PERM_ID - 权限ID：默认和菜单ID一致
     */
    public Long getPermId() {
        return permId;
    }

    /**
     * 设置权限ID：默认和菜单ID一致
     *
     * @param permId 权限ID：默认和菜单ID一致
     */
    public void setPermId(Long permId) {
        this.permId = permId;
    }

    /**
     * 获取图标索引
     *
     * @return ICON_INDEX - 图标索引
     */
    public String getIconIndex() {
        return iconIndex;
    }

    /**
     * 设置图标索引
     *
     * @param iconIndex 图标索引
     */
    public void setIconIndex(String iconIndex) {
        this.iconIndex = iconIndex;
    }

    /**
     * 获取资源所属系统编码：资源属于哪个系统，默认DEF
     *
     * @return RES_OWNER - 资源所属系统编码：资源属于哪个系统，默认DEF
     */
    public String getResOwner() {
        return resOwner;
    }

    /**
     * 设置资源所属系统编码：资源属于哪个系统，默认DEF
     *
     * @param resOwner 资源所属系统编码：资源属于哪个系统，默认DEF
     */
    public void setResOwner(String resOwner) {
        this.resOwner = resOwner;
    }

    /**
     * 获取打开方式：0-直接打开，1-新窗口
     *
     * @return OPEN_TYPE - 打开方式：0-直接打开，1-新窗口
     */
    public String getOpenType() {
        return openType;
    }

    /**
     * 设置打开方式：0-直接打开，1-新窗口
     *
     * @param openType 打开方式：0-直接打开，1-新窗口
     */
    public void setOpenType(String openType) {
        this.openType = openType;
    }

    /**
     * 获取排序号
     *
     * @return SORT_NO - 排序号
     */
    public Long getSortNo() {
        return sortNo;
    }

    /**
     * 设置排序号
     *
     * @param sortNo 排序号
     */
    public void setSortNo(Long sortNo) {
        this.sortNo = sortNo;
    }

    /**
     * 获取菜单设置：可以额外给菜单设置一些属性，JSON格式，{closeSideBar:true,isDefault:true}
     *
     * @return MENU_CONFIG - 菜单设置：可以额外给菜单设置一些属性，JSON格式，{closeSideBar:true,isDefault:true}
     */
    public String getMenuConfig() {
        return menuConfig;
    }

    /**
     * 设置菜单设置：可以额外给菜单设置一些属性，JSON格式，{closeSideBar:true,isDefault:true}
     *
     * @param menuConfig 菜单设置：可以额外给菜单设置一些属性，JSON格式，{closeSideBar:true,isDefault:true}
     */
    public void setMenuConfig(String menuConfig) {
        this.menuConfig = menuConfig;
    }

    /**
     * 获取层级关系：以英文逗号分割
     *
     * @return MENU_FRAME - 层级关系：以英文逗号分割
     */
    public String getMenuFrame() {
        return menuFrame;
    }

    /**
     * 设置层级关系：以英文逗号分割
     *
     * @param menuFrame 层级关系：以英文逗号分割
     */
    public void setMenuFrame(String menuFrame) {
        this.menuFrame = menuFrame;
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
     * 获取菜单是否维护中
     *
     * @return BREAK_TAG - 菜单是否维护中
     */
    public Boolean getBreakTag() {
        return breakTag;
    }

    /**
     * 设置菜单是否维护中
     *
     * @param breakTag 菜单是否维护中
     */
    public void setBreakTag(Boolean breakTag) {
        this.breakTag = breakTag;
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
     * 获取所属子系统编码：CRM,ERP,BI等
     *
     * @return SUBSYS_CODE - 所属子系统编码：CRM,ERP,BI等
     */
    public String getSubsysCode() {
        return subsysCode;
    }

    /**
     * 设置所属子系统编码：CRM,ERP,BI等
     *
     * @param subsysCode 所属子系统编码：CRM,ERP,BI等
     */
    public void setSubsysCode(String subsysCode) {
        this.subsysCode = subsysCode;
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