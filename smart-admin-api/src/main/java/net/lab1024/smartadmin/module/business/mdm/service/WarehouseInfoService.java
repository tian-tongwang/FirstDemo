package net.lab1024.smartadmin.module.business.mdm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.module.business.mdm.dao.WarehouseInfoDao;
import net.lab1024.smartadmin.module.business.mdm.domain.dto.WarehouseInfoAddDTO;
import net.lab1024.smartadmin.module.business.mdm.domain.dto.WarehouseInfoUpdateDTO;
import net.lab1024.smartadmin.module.business.mdm.domain.dto.WarehouseInfoQueryDTO;
import net.lab1024.smartadmin.module.business.mdm.domain.entity.WarehouseInfoEntity;
import net.lab1024.smartadmin.module.business.mdm.domain.vo.WarehouseInfoVO;
import net.lab1024.smartadmin.module.business.mdm.domain.vo.WarehouseInfoExcelVO;
import net.lab1024.smartadmin.util.SmartPageUtil;
import net.lab1024.smartadmin.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
public class WarehouseInfoService {

    @Autowired
    private WarehouseInfoDao warehouseInfoDao;

    /**
     * 根据id查询
     */
    public WarehouseInfoEntity getById(Long id){
        return  warehouseInfoDao.selectById(id);
    }

    /**
     * 分页查询
     * @author ttw
     * @date 2020-10-31 12:21:31
     */
    public ResponseDTO<PageResultDTO<WarehouseInfoVO>> queryByPage(WarehouseInfoQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<WarehouseInfoVO> voList = warehouseInfoDao.queryByPage(page, queryDTO);
        PageResultDTO<WarehouseInfoVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author ttw
     * @date 2020-10-31 12:21:31
     */
    public ResponseDTO<String> add(WarehouseInfoAddDTO addDTO) {
        WarehouseInfoEntity entity = SmartBeanUtil.copy(addDTO, WarehouseInfoEntity.class);
        warehouseInfoDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author ttw
     * @date 2020-10-31 12:21:31
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(WarehouseInfoUpdateDTO updateDTO) {
        WarehouseInfoEntity entity = SmartBeanUtil.copy(updateDTO, WarehouseInfoEntity.class);
        warehouseInfoDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author ttw
     * @date 2020-10-31 12:21:31
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<String> idList) {
        warehouseInfoDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author ttw
     * @date 2020-10-31 12:21:31
     */
    public List<WarehouseInfoExcelVO> queryAllExportData(WarehouseInfoQueryDTO queryDTO) {
        return warehouseInfoDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author ttw
     * @date 2020-10-31 12:21:31
     */
    public List<WarehouseInfoExcelVO> queryBatchExportData(List<String> idList) {
        return warehouseInfoDao.queryBatchExportData(idList);
    }

    /**
     * 查找所有仓库
     * @return
     */
    public List<WarehouseInfoVO> queryWareHouseList() {
        return warehouseInfoDao.queryWareHouseList();
    }
}
