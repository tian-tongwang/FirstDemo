package net.lab1024.smartadmin.module.business.mdm.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import java.util.Date;

/**
 *  [ 仓库信息 ]
 *
 * @author ttw
 * @version 1.0
 * @company 
 * @copyright (c) Inc. All rights reserved.
 * @date  2020-10-31 12:21:31
 * @since JDK1.8
 */
@Data
public class WarehouseInfoExcelVO {
    @Excel(name = "仓库编码")
    private String whCode;

    @Excel(name = "仓库名称")
    private String whName;

    @Excel(name = "创建者")
    private String createBy;

    @Excel(name = "创建时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Excel(name = "更新者")
    private String updateBy;

    @Excel(name = "更新时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;



}
