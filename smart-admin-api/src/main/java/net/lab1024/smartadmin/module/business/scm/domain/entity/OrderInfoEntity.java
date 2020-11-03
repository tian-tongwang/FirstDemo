package net.lab1024.smartadmin.module.business.scm.domain.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import net.lab1024.smartadmin.common.domain.BaseEntity;
import java.util.Date;
import java.util.List;

import lombok.Data;
import net.lab1024.smartadmin.module.business.scm.domain.dto.OrderInfosAddDTO;

/**
 * [ 采购订单 ]
 *
 * @author ttw
 * @version 1.0
 * @company 
 * @copyright (c)  Inc. All rights reserved.
 * @date 2020-10-31 15:49:36
 * @since JDK1.8
 */
@Data
@TableName("t_order_info")
public class OrderInfoEntity extends BaseEntity{

    /**
     * 采购订单号
     */
    @TableId
    private String billCode;

    /**
     * 供应商编码
     */
    private String btypeCode;

    /**
     * 供应商名称
     */
    private String btypeName;

    /**
     * 订单日期
     */
    private Date orderDate;

    /**
     * 仓库编码
     */
    private String whCode;

    /**
     * 仓库名称
     */
    private String whName;

    /**
     * 预计交货日期
     */
    private Date deliveryDate;

    /**
     * 采购类别
     */
    private String otName;

    /**
     * 采购明细
     */
    private List<OrderInfosAddDTO> orderBillsList;

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
