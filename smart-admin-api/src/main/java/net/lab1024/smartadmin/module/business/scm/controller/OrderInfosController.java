package net.lab1024.smartadmin.module.business.scm.controller;

import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.controller.BaseController;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.common.domain.ValidateList;
import net.lab1024.smartadmin.module.business.scm.domain.dto.OrderInfosAddDTO;
import net.lab1024.smartadmin.module.business.scm.domain.dto.OrderInfosUpdateDTO;
import net.lab1024.smartadmin.module.business.scm.domain.dto.OrderInfosQueryDTO;
import net.lab1024.smartadmin.module.business.scm.domain.vo.OrderInfosVO;
import net.lab1024.smartadmin.module.business.scm.domain.vo.OrderInfosExcelVO;
import net.lab1024.smartadmin.module.business.scm.service.OrderInfosService;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
@RestController
@Api(tags = {"采购明细"})
public class OrderInfosController extends BaseController {

    @Autowired
    private OrderInfosService orderInfosService;

    @ApiOperation(value = "分页查询采购明细",notes = "@author ttw")
    @PostMapping("/orderInfos/page/query")
    public ResponseDTO<PageResultDTO<OrderInfosVO>> queryByPage(@RequestBody OrderInfosQueryDTO queryDTO) {
        return orderInfosService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加采购明细",notes = "@author ttw")
    @PostMapping("/orderInfos/add")
    public ResponseDTO<String> add(@RequestBody @Validated OrderInfosAddDTO addTO){
        return orderInfosService.add(addTO);
    }

    @ApiOperation(value="修改采购明细",notes = "@author ttw")
    @PostMapping("/orderInfos/update")
    public ResponseDTO<String> update(@RequestBody @Validated OrderInfosUpdateDTO updateDTO){
        return orderInfosService.update(updateDTO);
    }

    @ApiOperation(value="批量删除采购明细",notes = "@author ttw")
    @PostMapping("/orderInfos/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return orderInfosService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author ttw")
    @PostMapping("/orderInfos/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<OrderInfosExcelVO> orderInfosList = orderInfosService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("采购明细", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, OrderInfosExcelVO.class, orderInfosList);
        downloadExcel("采购明细", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author ttw")
    @PostMapping("/orderInfos/export/all")
    public void exportAll(@RequestBody @Validated OrderInfosQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<OrderInfosExcelVO> orderInfosList = orderInfosService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("采购明细", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, OrderInfosExcelVO.class, orderInfosList);
        downloadExcel("采购明细", workbook, response);
    }

}
