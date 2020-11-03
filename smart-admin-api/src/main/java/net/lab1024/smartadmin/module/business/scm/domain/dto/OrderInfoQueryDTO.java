package net.lab1024.smartadmin.module.business.scm.domain.dto;

import net.lab1024.smartadmin.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import java.util.Date;

/**
 * [ 采购订单 ]
 *
 * @author ttw
 * @version 1.0
 * @company 
 * @copyright (c)  Inc. All rights reserved.
 * @date 2020-10-31 15:49:36
 * @since JDK1.8
 */
@Data
public class OrderInfoQueryDTO extends PageParamDTO {

    @ApiModelProperty("采购订单号")
    private String billCode;

    @ApiModelProperty("供应商编码")
    private String btypeCode;

    @ApiModelProperty("供应商名称")
    private String btypeName;

    @ApiModelProperty("订单日期")
    private Date orderDate;

    @ApiModelProperty("仓库编码")
    private String whCode;

    @ApiModelProperty("仓库名称")
    private String whName;

    @ApiModelProperty("预计交货日期")
    private Date deliveryDate;

    @ApiModelProperty("采购类别")
    private String otName;

    @ApiModelProperty("创建时间-开始")
    private Date createTimeBegin;

    @ApiModelProperty("创建时间-截止")
    private Date createTimeEnd;

    @ApiModelProperty("上次更新时间-开始")
    private Date updateTimeBegin;

    @ApiModelProperty("上次更新创建时间-开始")
    private Date updateTimeEnd;
}
