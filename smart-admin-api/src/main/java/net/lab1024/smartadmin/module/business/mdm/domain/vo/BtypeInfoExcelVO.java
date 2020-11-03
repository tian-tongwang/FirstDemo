package net.lab1024.smartadmin.module.business.mdm.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import java.util.Date;

/**
 *  [ 客户信息表 ]
 *
 * @author ttw
 * @version 1.0
 * @company 
 * @copyright (c) Inc. All rights reserved.
 * @date  2020-10-30 18:12:18
 * @since JDK1.8
 */
@Data
public class BtypeInfoExcelVO {
    @Excel(name = "客户编码")
    private String btypeCode;

    @Excel(name = "客户名称")
    private String btypeName;

    @Excel(name="单位类型")
    private String btypeSortName;

    @Excel(name = "创建者")
    private String createBy;

    @Excel(name = "创建时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Excel(name = "更新者")
    private String updateBy;

    @Excel(name = "更新时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;



}
