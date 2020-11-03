package net.lab1024.smartadmin.module.business.mdm.controller;

import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.controller.BaseController;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.common.domain.ValidateList;
import net.lab1024.smartadmin.module.business.mdm.domain.dto.WarehouseInfoAddDTO;
import net.lab1024.smartadmin.module.business.mdm.domain.dto.WarehouseInfoUpdateDTO;
import net.lab1024.smartadmin.module.business.mdm.domain.dto.WarehouseInfoQueryDTO;
import net.lab1024.smartadmin.module.business.mdm.domain.vo.WarehouseInfoVO;
import net.lab1024.smartadmin.module.business.mdm.domain.vo.WarehouseInfoExcelVO;
import net.lab1024.smartadmin.module.business.mdm.service.WarehouseInfoService;
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
 * [ 仓库信息 ]
 *
 * @author ttw
 * @version 1.0
 * @company 
 * @copyright (c)  Inc. All rights reserved.
 * @date 2020-10-31 12:21:31
 * @since JDK1.8
 */
@RestController
@Api(tags = {"仓库信息"})
public class WarehouseInfoController extends BaseController {

    @Autowired
    private WarehouseInfoService warehouseInfoService;

    @ApiOperation(value = "分页查询仓库信息",notes = "@author ttw")
    @PostMapping("/warehouseInfo/page/query")
    public ResponseDTO<PageResultDTO<WarehouseInfoVO>> queryByPage(@RequestBody WarehouseInfoQueryDTO queryDTO) {
        return warehouseInfoService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加仓库信息",notes = "@author ttw")
    @PostMapping("/warehouseInfo/add")
    public ResponseDTO<String> add(@RequestBody @Validated WarehouseInfoAddDTO addTO){
        return warehouseInfoService.add(addTO);
    }

    @ApiOperation(value="修改仓库信息",notes = "@author ttw")
    @PostMapping("/warehouseInfo/update")
    public ResponseDTO<String> update(@RequestBody @Validated WarehouseInfoUpdateDTO updateDTO){
        return warehouseInfoService.update(updateDTO);
    }

    @ApiOperation(value="批量删除仓库信息",notes = "@author ttw")
    @PostMapping("/warehouseInfo/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<String> idList) {
        return warehouseInfoService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author ttw")
    @PostMapping("/warehouseInfo/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<String> idList, HttpServletResponse response) {
        //查询数据
        List<WarehouseInfoExcelVO> warehouseInfoList = warehouseInfoService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("仓库信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, WarehouseInfoExcelVO.class, warehouseInfoList);
        downloadExcel("仓库信息", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author ttw")
    @PostMapping("/warehouseInfo/export/all")
    public void exportAll(@RequestBody @Validated WarehouseInfoQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<WarehouseInfoExcelVO> warehouseInfoList = warehouseInfoService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("仓库信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, WarehouseInfoExcelVO.class, warehouseInfoList);
        downloadExcel("仓库信息", workbook, response);
    }

    @ApiOperation(value = "查找所有仓库信息",notes = "@author ttw")
    @PostMapping("/warehouseInfo/queryWareHouseList")
    public List<WarehouseInfoVO> queryWareHouseList(){
        return warehouseInfoService.queryWareHouseList();
    }

}
