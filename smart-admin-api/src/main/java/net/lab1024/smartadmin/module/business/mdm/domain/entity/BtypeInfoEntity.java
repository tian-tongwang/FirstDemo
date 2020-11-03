package net.lab1024.smartadmin.module.business.mdm.domain.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import net.lab1024.smartadmin.common.domain.BaseEntity;
import lombok.Data;

/**
 * [ 客户信息表 ]
 *
 * @author ttw
 * @version 1.0
 * @company 
 * @copyright (c)  Inc. All rights reserved.
 * @date 2020-10-30 18:12:18
 * @since JDK1.8
 */
@Data
@TableName("t_btype_info")
public class BtypeInfoEntity extends BaseEntity{

    /**
     * 客户编码
     */
    @TableId
    private String btypeCode;

    /**
     * 客户名称
     */
    private String btypeName;

//    /**
//     * 往来单位类型 0供应商 1客户
//     */
//    @TableField(value = "btype_sort")
//    private String btypeSort;

    /**
     * w往来单位类型名称
     */
    @TableField(value="btype_sort_name")
    private String btypeSortName;

    /*
     * 创建者
     */
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;

    /*
     * 更新者
     * */
    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

}
