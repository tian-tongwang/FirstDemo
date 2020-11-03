package net.lab1024.smartadmin.module.business.scm.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import java.math.BigDecimal;

/**
 *  [ 采购明细 ]
 *
 * @author ttw
 * @version 1.0
 * @company 
 * @copyright (c) Inc. All rights reserved.
 * @date  2020-11-03 21:03:34
 * @since JDK1.8
 */
@Data
public class OrderInfosExcelVO {
    @Excel(name = "主键")
    private Long id;

    @Excel(name = "主表关联字段 单号")
    private String billCode;

    @Excel(name = "产品编码")
    private String invCode;

    @Excel(name = "产品名称")
    private String invName;

    @Excel(name = "产品单位")
    private String invUnit;

    @Excel(name = "数量")
    private Integer qty;

    @Excel(name = "价格")
    private BigDecimal price;

    @Excel(name = "合计额")
    private BigDecimal sumMoney;

    @Excel(name = "优惠额")
    private BigDecimal discountMoney;

    @Excel(name = "实际花费")
    private BigDecimal costMoney;



}
