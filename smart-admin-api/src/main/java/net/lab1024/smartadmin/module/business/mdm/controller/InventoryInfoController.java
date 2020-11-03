package net.lab1024.smartadmin.module.business.mdm.controller;

import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.controller.BaseController;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.common.domain.ValidateList;
import net.lab1024.smartadmin.module.business.mdm.domain.dto.InventoryInfoAddDTO;
import net.lab1024.smartadmin.module.business.mdm.domain.dto.InventoryInfoUpdateDTO;
import net.lab1024.smartadmin.module.business.mdm.domain.dto.InventoryInfoQueryDTO;
import net.lab1024.smartadmin.module.business.mdm.domain.vo.InventoryInfoVO;
import net.lab1024.smartadmin.module.business.mdm.domain.vo.InventoryInfoExcelVO;
import net.lab1024.smartadmin.module.business.mdm.service.InventoryInfoService;
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
 * [ 商品信息表 ]
 *
 * @author ttw
 * @version 1.0
 * @company 
 * @copyright (c)  Inc. All rights reserved.
 * @date 2020-10-30 17:18:51
 * @since JDK1.8
 */
@RestController
@Api(tags = {"商品信息表"})
public class InventoryInfoController extends BaseController {

    @Autowired
    private InventoryInfoService inventoryInfoService;

    @ApiOperation(value = "分页查询商品信息表",notes = "@author ttw")
    @PostMapping("/inventoryInfo/page/query")
    public ResponseDTO<PageResultDTO<InventoryInfoVO>> queryByPage(@RequestBody InventoryInfoQueryDTO queryDTO) {
        return inventoryInfoService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加商品信息表",notes = "@author ttw")
    @PostMapping("/inventoryInfo/add")
    public ResponseDTO<String> add(@RequestBody @Validated InventoryInfoAddDTO addTO){
        return inventoryInfoService.add(addTO);
    }

    @ApiOperation(value="修改商品信息表",notes = "@author ttw")
    @PostMapping("/inventoryInfo/update")
    public ResponseDTO<String> update(@RequestBody @Validated InventoryInfoUpdateDTO updateDTO){
        return inventoryInfoService.update(updateDTO);
    }

    @ApiOperation(value="批量删除商品信息表",notes = "@author ttw")
    @PostMapping("/inventoryInfo/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<String> idList) {
        return inventoryInfoService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author ttw")
    @PostMapping("/inventoryInfo/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<String> idList, HttpServletResponse response) {
        //查询数据
        List<InventoryInfoExcelVO> inventoryInfoList = inventoryInfoService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("商品信息表", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, InventoryInfoExcelVO.class, inventoryInfoList);
        downloadExcel("商品信息表", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author ttw")
    @PostMapping("/inventoryInfo/export/all")
    public void exportAll(@RequestBody @Validated InventoryInfoQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<InventoryInfoExcelVO> inventoryInfoList = inventoryInfoService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("商品信息表", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, InventoryInfoExcelVO.class, inventoryInfoList);
        downloadExcel("商品信息表", workbook, response);
    }

    @ApiOperation(value="分类信息",notes = "@author ttw")
    @PostMapping("/inventoryInfo/sortInfo")
    public List<InventoryInfoVO> querySortInfo(){
        return inventoryInfoService.querySortInfo();
    }
    @ApiOperation(value="品牌信息",notes = "@author ttw")
    @PostMapping("/inventoryInfo/brandInfo")
    public List<InventoryInfoVO> queryBrandInfo(){
        return inventoryInfoService.queryBrandInfo();
    }

}
