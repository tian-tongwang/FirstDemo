package net.lab1024.smartadmin.module.business.scm.domain.vo;

import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 *  [ 采购订单 ]
 *
 * @author ttw
 * @version 1.0
 * @company 
 * @copyright (c) Inc. All rights reserved.
 * @date  2020-10-31 15:49:36
 * @since JDK1.8
 */
@Data
public class OrderInfoVO {
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

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("更新者")
    private String updateBy;

}
