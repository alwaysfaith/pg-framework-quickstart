package com.sf.request.sys;

import com.sf.pg.entity.IRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;


/**
 * @author lijie.zh
 */
@Getter
@Setter
public class SysDictDelRequest implements IRequest {

    @ApiModelProperty("字典ID")
    @NotNull
    Long[] dictId;

}
