package net.lab1024.smartadmin.module.business.mdm.domain.dto;

import net.lab1024.smartadmin.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

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
public class InventoryInfoQueryDTO extends PageParamDTO {

    @ApiModelProperty("产品名称")
    private String invName;

    @ApiModelProperty("产品编码")
    private String invCode;

    @ApiModelProperty("分类编码")
    private String sortCode;

    @ApiModelProperty("分类名称")
    private String sortName;

    @ApiModelProperty("品牌名称")
    private String brandName;

    @ApiModelProperty("品牌编码")
    private String brandCode;

    @ApiModelProperty("产品单位")
    private String invUnit;

    @ApiModelProperty("创建时间-开始")
    private Date createTimeBegin;

    @ApiModelProperty("创建时间-截止")
    private Date createTimeEnd;

    @ApiModelProperty("上次更新时间-开始")
    private Date updateTimeBegin;

    @ApiModelProperty("上次更新创建时间-开始")
    private Date updateTimeEnd;
}
