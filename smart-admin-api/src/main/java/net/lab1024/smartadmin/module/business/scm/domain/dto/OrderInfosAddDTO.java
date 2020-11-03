package net.lab1024.smartadmin.module.business.scm.domain.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新建 [ 采购明细 ]
 *
 * @author ttw
 * @version 1.0
 * @company 
 * @copyright (c) 2018 Inc. All rights reserved.
 * @date  2020-11-03 21:03:34
 * @since JDK1.8
 */
@Data
public class OrderInfosAddDTO {

    @ApiModelProperty("主键id")
    private String id;

    @ApiModelProperty("主表关联字段 单号")
    private String billCode;

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

    @ApiModelProperty("创建日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}
