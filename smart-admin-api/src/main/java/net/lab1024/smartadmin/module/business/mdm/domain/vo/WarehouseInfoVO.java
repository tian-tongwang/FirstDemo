package net.lab1024.smartadmin.module.business.mdm.domain.vo;

import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

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
public class WarehouseInfoVO {
    @ApiModelProperty("仓库编码")
    private String whCode;

    @ApiModelProperty("仓库名称")
    private String whName;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;



}
