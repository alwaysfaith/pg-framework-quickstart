package com.sf.request.sys;

import com.sf.pg.entity.IRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;


/**
 * @author lijie.zh
 */
@Getter
@Setter
public class SysMenuBaseRequest implements IRequest {

    /**
     * 上级菜单ID
     */
    @ApiModelProperty("上级菜单ID")
    @NotNull
    private Long parentMenuId;

    /**
     * 菜单名称
     */
    @ApiModelProperty("菜单名称")
    @NotNull
    private String menuName;

    /**
     * 菜单文字说明
     */
    @ApiModelProperty("菜单文字说明")
    private String menuDesc;

    /**
     * url前缀：例如，http://www.xxx.com, 前缀+上下文+url共同组成菜单的详细地址
     */
    @ApiModelProperty("url前缀")
    private String urlPerfix;

    /**
     * 模块上下文：例如 /crm
     */
    @ApiModelProperty("模块上下文：例如 /crm")
    private String modContext;

    /**
     * 菜单资源地址：例如/sys/user/get?init=true
     */
    @ApiModelProperty("菜单资源地址：例如/sys/user/get?init=true")
    private String menuUrl;

    /**
     * 图标索引
     */
    @ApiModelProperty("图标索引")
    private String iconIndex;

    /**
     * 资源所属系统编码：资源属于哪个系统，默认DEF
     */
    @ApiModelProperty("资源所属系统编码：资源属于哪个系统，默认DEF")
    private String resOwner;

    /**
     * 打开方式：0-直接打开，1-新窗口
     */
    @ApiModelProperty(" 打开方式：0-直接打开，1-新窗口")
    private String openType;

    /**
     * 排序号
     */
    @ApiModelProperty(" 排序号")
    private Long sortNo;

    /**
     * 菜单设置：可以额外给菜单设置一些属性，JSON格式，{closeSideBar:true,isDefault:true}
     */
    @ApiModelProperty(" 菜单设置：可以额外给菜单设置一些属性，JSON格式，{closeSideBar:true,isDefault:true}")
    private String menuConfig;

    /**
     * 备注
     */
    @ApiModelProperty(" 备注")
    private String remark;

    /**
     * 菜单是否维护中
     */
    @ApiModelProperty(" 菜单是否维护中")
    private Boolean breakTag;


    /**
     * 所属子系统编码：CRM,ERP,BI等
     */
    @ApiModelProperty("所属子系统编码：CRM,ERP,BI等")
    private String subsysCode;

}
