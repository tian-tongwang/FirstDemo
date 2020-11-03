package net.lab1024.smartadmin.module.business.mdm.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import java.util.Date;

/**
 *  [ 商品信息表 ]
 *
 * @author ttw
 * @version 1.0
 * @company 
 * @copyright (c) Inc. All rights reserved.
 * @date  2020-10-30 17:18:51
 * @since JDK1.8
 */
@Data
public class InventoryInfoExcelVO {
    @Excel(name = "产品编码")
    private String invCode;

    @Excel(name = "产品名称")
    private String invName;

    @Excel(name = "产品单位")
    private String invUnit;

    @Excel(name = "分类编码")
    private String sortCode;

    @Excel(name = "分类名称")
    private String sortName;

    @Excel(name = "品牌编码")
    private String brandCode;

    @Excel(name = "品牌名称")
    private String brandName;

    @Excel(name = "创建者")
    private String createBy;

    @Excel(name = "创建日期", format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Excel(name = "更新者")
    private String updateBy;

    @Excel(name = "更新日期", format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;



}
