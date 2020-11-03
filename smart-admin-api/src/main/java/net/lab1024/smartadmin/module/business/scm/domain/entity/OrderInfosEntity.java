package net.lab1024.smartadmin.module.business.scm.domain.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import net.lab1024.smartadmin.common.domain.BaseEntity;
import java.math.BigDecimal;
import lombok.Data;

/**
 * [ 采购明细 ]
 *
 * @author ttw
 * @version 1.0
 * @company 
 * @copyright (c)  Inc. All rights reserved.
 * @date 2020-11-03 21:03:34
 * @since JDK1.8
 */
@Data
@TableName("t_order_infos")
public class OrderInfosEntity extends BaseEntity{

    /**
     * 明细主键
     */
    private String id;
    /**
     * 主表关联字段 单号
     */
    private String billCode;

    /**
     * 产品编码
     */
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
     * 数量
     */
    private Integer qty;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 合计额
     */
    private BigDecimal sumMoney;

    /**
     * 优惠额
     */
    private BigDecimal discountMoney;

    /**
     * 实际花费
     */
    private BigDecimal costMoney;

    /**
     * 创建者
     */
    @TableField(value = "create_by",fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 更新者
     */
    @TableField(value = "update_by",fill = FieldFill.INSERT_UPDATE)
    private String updateBy;
}
