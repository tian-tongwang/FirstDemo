package net.lab1024.smartadmin.module.business.mdm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.module.business.mdm.dao.InventoryInfoDao;
import net.lab1024.smartadmin.module.business.mdm.domain.dto.InventoryInfoAddDTO;
import net.lab1024.smartadmin.module.business.mdm.domain.dto.InventoryInfoUpdateDTO;
import net.lab1024.smartadmin.module.business.mdm.domain.dto.InventoryInfoQueryDTO;
import net.lab1024.smartadmin.module.business.mdm.domain.entity.InventoryInfoEntity;
import net.lab1024.smartadmin.module.business.mdm.domain.vo.InventoryInfoVO;
import net.lab1024.smartadmin.module.business.mdm.domain.vo.InventoryInfoExcelVO;
import net.lab1024.smartadmin.util.SmartPageUtil;
import net.lab1024.smartadmin.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
public class InventoryInfoService {

    @Autowired
    private InventoryInfoDao inventoryInfoDao;

    /**
     * 根据id查询
     */
    public InventoryInfoEntity getById(Long id){
        return  inventoryInfoDao.selectById(id);
    }

    /**
     * 分页查询
     * @author ttw
     * @date 2020-10-30 17:18:51
     */
    public ResponseDTO<PageResultDTO<InventoryInfoVO>> queryByPage(InventoryInfoQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<InventoryInfoVO> voList = inventoryInfoDao.queryByPage(page, queryDTO);
        PageResultDTO<InventoryInfoVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author ttw
     * @date 2020-10-30 17:18:51
     */
    public ResponseDTO<String> add(InventoryInfoAddDTO addDTO) {
        InventoryInfoEntity entity = SmartBeanUtil.copy(addDTO, InventoryInfoEntity.class);
        inventoryInfoDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author ttw
     * @date 2020-10-30 17:18:51
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(InventoryInfoUpdateDTO updateDTO) {
        InventoryInfoEntity entity = SmartBeanUtil.copy(updateDTO, InventoryInfoEntity.class);
        inventoryInfoDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author ttw
     * @date 2020-10-30 17:18:51
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<String> idList) {
        inventoryInfoDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author ttw
     * @date 2020-10-30 17:18:51
     */
    public List<InventoryInfoExcelVO> queryAllExportData(InventoryInfoQueryDTO queryDTO) {
        return inventoryInfoDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author ttw
     * @date 2020-10-30 17:18:51
     */
    public List<InventoryInfoExcelVO> queryBatchExportData(List<String> idList) {
        return inventoryInfoDao.queryBatchExportData(idList);
    }

    /**
     * 查询所有分类信息
     * @return
     */
    public List<InventoryInfoVO> querySortInfo(){
        return inventoryInfoDao.querySortInfo();
    }

    /**
     * 查询所有品牌信息
     * @return
     */
    public List<InventoryInfoVO> queryBrandInfo(){
        return inventoryInfoDao.queryBrandInfo();
    }
}
