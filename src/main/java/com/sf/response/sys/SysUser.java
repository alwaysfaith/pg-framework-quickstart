package com.sf.response.sys;

import com.sf.core.converter.DeptConverter;
import com.sf.core.converter.DictConverter;
import com.sf.pg.core.convert.Code2Name;
import com.sf.response.CommonField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 当前用户实体类，可以从当前会话中获取到
 *
 * @author lijie.zh
 */
@Getter
@Setter
public class SysUser extends CommonField {

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("用户名称")
    private String userName;

    @ApiModelProperty("工号")
    private String staffId;

    @ApiModelProperty("手机号码")
    private String mobileNo;

    @ApiModelProperty("性别值")
    private String sex;

    @ApiModelProperty("性别文字")
    @Code2Name(key = "SYS_SEX", codeFrom = "sex", converter = DictConverter.class)
    private String sexName;

    @ApiModelProperty("头像URL")
    private String avatar;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("部门ID")
    private Long deptId;

    @Code2Name(codeFrom = "deptId", converter = DeptConverter.class)
    @ApiModelProperty("部门名称")
    private String deptName;

    @ApiModelProperty("有效状态")
    private Boolean validTag;

    @Code2Name(key = "SYS_VALID_TAG", codeFrom = "validTag", converter = DictConverter.class)
    @ApiModelProperty("有效状态-文字")
    private String validTagName;


}
