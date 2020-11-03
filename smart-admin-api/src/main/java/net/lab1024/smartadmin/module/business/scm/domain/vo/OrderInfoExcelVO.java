package net.lab1024.smartadmin.module.business.scm.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import lombok.Data;
import java.util.Date;

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
public class OrderInfoExcelVO {
    @Excel(name = "采购订单号")
    private String billCode;

    @Excel(name = "供应商编码")
    private String btypeCode;

    @Excel(name = "供应商名称")
    private String btypeName;

    @Excel(name = "订单日期", format = "yyyy-MM-dd HH:mm:ss")
    private Date orderDate;

    @Excel(name = "仓库编码")
    private String whCode;

    @Excel(name = "仓库名称")
    private String whName;

    @Excel(name = "预计交货日期", format = "yyyy-MM-dd HH:mm:ss")
    private Date deliveryDate;

    @Excel(name = "采购类别")
    private String otName;

    @Excel(name = "创建者")
    private String createBy;

    @Excel(name = "创建时间")
    private Date createTime;

    @Excel(name = "更新者")
    private String updateBy;

    @Excel(name = "更新时间")
    private Date updateTime;


}
