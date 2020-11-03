package net.lab1024.smartadmin.module.business.utils.domain.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import net.lab1024.smartadmin.common.domain.BaseEntity;
import lombok.Data;

/**
 * [ 最大单号记录 ]
 *
 * @author ttw
 * @version 1.0
 * @company 
 * @copyright (c)  Inc. All rights reserved.
 * @date 2020-10-31 14:55:56
 * @since JDK1.8
 */
@Data
@TableName("sys_max_code")
public class SysMaxCodeEntity{

    /**
     * 订单类型编码
     */
    @TableId
    private String billType;

    /**
     * 年份
     */
    private String year;

    /**
     * 最大数
     */
    private Integer maxCode;

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
