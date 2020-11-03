package net.lab1024.smartadmin.module.business.mdm.domain.dto;

import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新建 [ 仓库信息 ]
 *
 * @author ttw
 * @version 1.0
 * @company 
 * @copyright (c) 2018 Inc. All rights reserved.
 * @date  2020-10-31 12:21:31
 * @since JDK1.8
 */
@Data
public class WarehouseInfoAddDTO {
    @ApiModelProperty("仓库编码")
    private String whCode;

    @ApiModelProperty("仓库名称")
    private String whName;

    @ApiModelProperty("创建日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}
