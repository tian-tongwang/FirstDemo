package net.lab1024.smartadmin.module.business.mdm.domain.vo;

import io.swagger.annotations.ApiOperation;
import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 *  [ 客户信息表 ]
 *
 * @author ttw
 * @version 1.0
 * @company 
 * @copyright (c) Inc. All rights reserved.
 * @date  2020-10-30 18:12:18
 * @since JDK1.8
 */
@Data
public class BtypeInfoVO {
    @ApiModelProperty("客户编码")
    private String btypeCode;

    @ApiModelProperty("客户名称")
    private String btypeName;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("更新者")
    private String updateBy;

//    @ApiModelProperty("类型")
//    private String btypeSort;

    @ApiModelProperty("类型名称")
    private String btypeSortName;


}
