package net.lab1024.smartadmin.module.business.scm.domain.dto;

import net.lab1024.smartadmin.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

/**
 * [ 采购明细 ]
 *
 * @author ttw
 * @version 1.0
 * @company 
 * @copyright (c)  Inc. All rights reserved.
 * @date 2020-11-03 21:03:34
 * @since JDK1.8
 */
@Data
public class OrderInfosQueryDTO extends PageParamDTO {

    @ApiModelProperty("产品编码")
    private String invCode;

    @ApiModelProperty("产品名称")
    private String invName;

    @ApiModelProperty("产品单位")
    private String invUnit;

    @ApiModelProperty("数量")
    private Integer qty;

    @ApiModelProperty("价格")
    private BigDecimal price;

    @ApiModelProperty("合计额")
    private BigDecimal sumMoney;

    @ApiModelProperty("优惠额")
    private BigDecimal discountMoney;

    @ApiModelProperty("实际花费")
    private BigDecimal costMoney;

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("主表关联字段 单号")
    private String billCode;

    @ApiModelProperty("创建时间-开始")
    private Date createTimeBegin;

    @ApiModelProperty("创建时间-截止")
    private Date createTimeEnd;

    @ApiModelProperty("上次更新时间-开始")
    private Date updateTimeBegin;

    @ApiModelProperty("上次更新创建时间-开始")
    private Date updateTimeEnd;
}
