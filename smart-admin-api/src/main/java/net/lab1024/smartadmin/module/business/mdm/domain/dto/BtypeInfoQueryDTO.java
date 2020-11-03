package net.lab1024.smartadmin.module.business.mdm.domain.dto;

import net.lab1024.smartadmin.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * [ 客户信息表 ]
 *
 * @author ttw
 * @version 1.0
 * @company 
 * @copyright (c)  Inc. All rights reserved.
 * @date 2020-10-30 18:12:18
 * @since JDK1.8
 */
@Data
public class BtypeInfoQueryDTO extends PageParamDTO {

    @ApiModelProperty("客户编码")
    private String btypeCode;

    @ApiModelProperty("客户名称")
    private String btypeName;

    @ApiModelProperty("创建时间-开始")
    private Date createTimeBegin;

    @ApiModelProperty("创建时间-截止")
    private Date createTimeEnd;

    @ApiModelProperty("上次更新时间-开始")
    private Date updateTimeBegin;

    @ApiModelProperty("上次更新创建时间-开始")
    private Date updateTimeEnd;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("更新者")
    private String updateBy;

//    @ApiModelProperty("类型")
//    private String btypeSort;

    @ApiModelProperty("类型名称")
    private String btypeSortName;
}
