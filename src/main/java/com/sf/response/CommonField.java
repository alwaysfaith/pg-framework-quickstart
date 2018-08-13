package com.sf.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.sf.core.converter.UserConverter;
import com.sf.pg.core.convert.Code2Name;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 当前用户实体类，可以从当前会话中获取到
 *
 * @author lijie.zh
 */
@Getter
@Setter
public class CommonField {

    @ApiModelProperty("创建人ID")
    private String createBy;

    @Code2Name(codeFrom = "createBy", converter = UserConverter.class)
    @ApiModelProperty("创建人姓名")
    private String createByName;

    @ApiModelProperty("修改人ID")
    private String updateBy;

    @Code2Name(codeFrom = "updateBy", converter = UserConverter.class)
    @ApiModelProperty("修改人姓名")
    private String updateByName;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间")
    private Date createTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("修改时间")
    private Date updateTime;

}
