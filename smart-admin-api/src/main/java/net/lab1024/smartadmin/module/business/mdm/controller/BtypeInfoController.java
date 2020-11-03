package net.lab1024.smartadmin.module.business.mdm.controller;

import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.controller.BaseController;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.common.domain.ValidateList;
import net.lab1024.smartadmin.module.business.mdm.domain.dto.BtypeInfoAddDTO;
import net.lab1024.smartadmin.module.business.mdm.domain.dto.BtypeInfoUpdateDTO;
import net.lab1024.smartadmin.module.business.mdm.domain.dto.BtypeInfoQueryDTO;
import net.lab1024.smartadmin.module.business.mdm.domain.vo.BtypeInfoVO;
import net.lab1024.smartadmin.module.business.mdm.domain.vo.BtypeInfoExcelVO;
import net.lab1024.smartadmin.module.business.mdm.service.BtypeInfoService;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import net.lab1024.smartadmin.module.system.login.domain.RequestTokenBO;
import net.lab1024.smartadmin.util.SmartRequestTokenUtil;
import org.apache.poi.ss.usermodel.Workbook;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * [ 客户信息表 ]
 *
 * @author ttw
 * @version 1.0
 * @company 
 * @copyright (c)  Inc. All rights reserved.
 * @date 2020-10-30 18:12:18
 * @since JDK1.8
 */
@RestController
@Api(tags = {"客户信息表"})
public class BtypeInfoController extends BaseController {

    @Autowired
    private BtypeInfoService btypeInfoService;

    @ApiOperation(value = "分页查询客户信息表",notes = "@author ttw")
    @PostMapping("/btypeInfo/page/query")
    public ResponseDTO<PageResultDTO<BtypeInfoVO>> queryByPage(@RequestBody BtypeInfoQueryDTO queryDTO) {
        return btypeInfoService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加客户信息表",notes = "@author ttw")
    @PostMapping("/btypeInfo/add")
    public ResponseDTO<String> add(@RequestBody @Validated BtypeInfoAddDTO addTO){
//        //获取发起请求人
//        RequestTokenBO requestToken = SmartRequestTokenUtil.getRequestUser();
//        //设置创建者
//        addTO.setCreateBy(requestToken.getEmployeeBO().getActualName());
//        //设置更新者
//        addTO.setUpdateBy(requestToken.getEmployeeBO().getActualName());
        return btypeInfoService.add(addTO);
    }

    @ApiOperation(value="修改客户信息表",notes = "@author ttw")
    @PostMapping("/btypeInfo/update")
    public ResponseDTO<String> update(@RequestBody @Validated BtypeInfoUpdateDTO updateDTO){
//        //获取发起请求人
//        RequestTokenBO requestToken = SmartRequestTokenUtil.getRequestUser();
//        //设置更新者
//        updateDTO.setUpdateBy(requestToken.getEmployeeBO().getActualName());
        return btypeInfoService.update(updateDTO);
    }

    @ApiOperation(value="批量删除客户信息表",notes = "@author ttw")
    @PostMapping("/btypeInfo/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<String> idList) {
        return btypeInfoService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author ttw")
    @PostMapping("/btypeInfo/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<String> idList, HttpServletResponse response) {
        //查询数据
        List<BtypeInfoExcelVO> btypeInfoList = btypeInfoService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("客户信息表", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, BtypeInfoExcelVO.class, btypeInfoList);
        downloadExcel("客户信息表", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author ttw")
    @PostMapping("/btypeInfo/export/all")
    public void exportAll(@RequestBody @Validated BtypeInfoQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<BtypeInfoExcelVO> btypeInfoList = btypeInfoService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("客户信息表", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, BtypeInfoExcelVO.class, btypeInfoList);
        downloadExcel("客户信息表", workbook, response);
    }

    @ApiOperation(value = "获取全部单位",notes = "@author ttw")
    @PostMapping("/btypeInfo/queryBtypeInfoList")
    public List<BtypeInfoVO> queryBtypeInfoList(@RequestBody String btypeSortName){
        return  btypeInfoService.queryBtypeInfoList(btypeSortName);
    }

}
