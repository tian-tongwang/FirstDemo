package net.lab1024.smartadmin.module.business.mdm.domain.dto;

import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新建 [ 商品信息表 ]
 *
 * @author ttw
 * @version 1.0
 * @company 
 * @copyright (c) 2018 Inc. All rights reserved.
 * @date  2020-10-30 17:18:51
 * @since JDK1.8
 */
@Data
public class InventoryInfoAddDTO {
    @ApiModelProperty("产品编码")
    private String invCode;

    @ApiModelProperty("产品名称")
    private String invName;

    @ApiModelProperty("产品单位")
    private String invUnit;

    @ApiModelProperty("分类编码")
    private String sortCode;

    @ApiModelProperty("分类名称")
    private String sortName;

    @ApiModelProperty("品牌编码")
    private String brandCode;

    @ApiModelProperty("品牌名称")
    private String brandName;

    @ApiModelProperty("创建日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;


}
