package net.lab1024.smartadmin.module.business.mdm.domain.dto;

import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新建 [ 客户信息表 ]
 *
 * @author ttw
 * @version 1.0
 * @company 
 * @copyright (c) 2018 Inc. All rights reserved.
 * @date  2020-10-30 18:12:18
 * @since JDK1.8
 */
@Data
public class BtypeInfoAddDTO {
    @ApiModelProperty("客户编码")
    private String btypeCode;

    @ApiModelProperty("客户名称")
    private String btypeName;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("更新者")
    private String updateBy;

//    @ApiModelProperty("类型")
//    private String btypeSort;

    @ApiModelProperty("类型名称")
    private String btypeSortName;

}
