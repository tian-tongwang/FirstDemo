package net.lab1024.smartadmin.module.business.mdm.domain.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import net.lab1024.smartadmin.common.domain.BaseEntity;
import lombok.Data;

/**
 * [ 商品信息表 ]
 *
 * @author ttw
 * @version 1.0
 * @company 
 * @copyright (c)  Inc. All rights reserved.
 * @date 2020-10-30 17:18:51
 * @since JDK1.8
 */
@Data
@TableName("t_inventory_info")
public class InventoryInfoEntity extends BaseEntity{

    /**
     * 产品编码
     */
    @TableId
    private String invCode;

    /**
     * 产品名称
     */
    private String invName;

    /**
     * 产品单位
     */
    private String invUnit;

    /**
     * 分类编码
     */
    private String sortCode;

    /**
     * 分类名称
     */
    private String sortName;

    /**
     * 品牌编码
     */
    private String brandCode;

    /**
     * 品牌名称
     */
    private String brandName;

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
