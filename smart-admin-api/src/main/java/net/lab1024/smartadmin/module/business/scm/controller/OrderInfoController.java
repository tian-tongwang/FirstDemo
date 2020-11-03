package net.lab1024.smartadmin.module.business.scm.controller;

import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.controller.BaseController;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.common.domain.ValidateList;
import net.lab1024.smartadmin.module.business.common.BillTypeUtils;
import net.lab1024.smartadmin.module.business.mdm.domain.entity.BtypeInfoEntity;
import net.lab1024.smartadmin.module.business.scm.domain.dto.OrderInfoAddDTO;
import net.lab1024.smartadmin.module.business.scm.domain.dto.OrderInfoUpdateDTO;
import net.lab1024.smartadmin.module.business.scm.domain.dto.OrderInfoQueryDTO;
import net.lab1024.smartadmin.module.business.scm.domain.dto.OrderInfosAddDTO;
import net.lab1024.smartadmin.module.business.scm.domain.entity.OrderInfosEntity;
import net.lab1024.smartadmin.module.business.scm.domain.vo.OrderInfoVO;
import net.lab1024.smartadmin.module.business.scm.domain.vo.OrderInfoExcelVO;
import net.lab1024.smartadmin.module.business.scm.service.OrderInfoService;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import net.lab1024.smartadmin.module.business.scm.service.OrderInfosService;
import net.lab1024.smartadmin.util.SmartBeanUtil;
import org.apache.poi.ss.usermodel.Workbook;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
@RestController
@Api(tags = {"采购订单"})
public class OrderInfoController extends BaseController {

    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private OrderInfosService orderInfosService;
    @Autowired
    private BillTypeUtils billTypeUtils;

    @ApiOperation(value = "分页查询采购订单",notes = "@author ttw")
    @PostMapping("/orderInfo/page/query")
    public ResponseDTO<PageResultDTO<OrderInfoVO>> queryByPage(@RequestBody OrderInfoQueryDTO queryDTO) {
        return orderInfoService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加采购订单",notes = "@author ttw")
    @PostMapping("/orderInfo/add")
    public ResponseDTO<String> add(@RequestBody @Validated OrderInfoAddDTO addTO){
        addTO.setBillCode(billTypeUtils.getMaxBillCode(billTypeUtils.CG));
        return orderInfoService.add(addTO);
    }

    @ApiOperation(value="修改采购订单",notes = "@author ttw")
    @PostMapping("/orderInfo/update")
    public ResponseDTO<String> update(@RequestBody @Validated OrderInfoUpdateDTO updateDTO){
        return orderInfoService.update(updateDTO);
    }

    @ApiOperation(value="批量删除采购订单",notes = "@author ttw")
    @PostMapping("/orderInfo/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<String> idList) {
        return orderInfoService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author ttw")
    @PostMapping("/orderInfo/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<String> idList, HttpServletResponse response) {
        //查询数据
        List<OrderInfoExcelVO> orderInfoList = orderInfoService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("采购订单", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, OrderInfoExcelVO.class, orderInfoList);
        downloadExcel("采购订单", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author ttw")
    @PostMapping("/orderInfo/export/all")
    public void exportAll(@RequestBody @Validated OrderInfoQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<OrderInfoExcelVO> orderInfoList = orderInfoService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("采购订单", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, OrderInfoExcelVO.class, orderInfoList);
        downloadExcel("采购订单", workbook, response);
    }

}
