package net.lab1024.smartadmin.module.business.scm.domain.dto;

import lombok.Data;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import net.lab1024.smartadmin.module.business.scm.domain.entity.OrderInfosEntity;

/**
 * 新建 [ 采购订单 ]
 *
 * @author ttw
 * @version 1.0
 * @company 
 * @copyright (c) 2018 Inc. All rights reserved.
 * @date  2020-10-31 15:49:36
 * @since JDK1.8
 */
@Data
public class OrderInfoAddDTO {
    @ApiModelProperty("采购订单号")
    private String billCode;

    @ApiModelProperty("供应商编码")
    private String btypeCode;

    @ApiModelProperty("供应商名称")
    private String btypeName;

    @ApiModelProperty("订单日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date orderDate;

    @ApiModelProperty("仓库编码")
    private String whCode;

    @ApiModelProperty("仓库名称")
    private String whName;

    @ApiModelProperty("预计交货日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date deliveryDate;

    @ApiModelProperty("采购类别")
    private String otName;

    @ApiModelProperty("创建日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @ApiModelProperty("采购明细")
    private List<OrderInfosAddDTO> orderBillsList;


}
