package net.lab1024.smartadmin.module.business.mdm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.module.business.mdm.dao.BtypeInfoDao;
import net.lab1024.smartadmin.module.business.mdm.domain.dto.BtypeInfoAddDTO;
import net.lab1024.smartadmin.module.business.mdm.domain.dto.BtypeInfoUpdateDTO;
import net.lab1024.smartadmin.module.business.mdm.domain.dto.BtypeInfoQueryDTO;
import net.lab1024.smartadmin.module.business.mdm.domain.entity.BtypeInfoEntity;
import net.lab1024.smartadmin.module.business.mdm.domain.vo.BtypeInfoVO;
import net.lab1024.smartadmin.module.business.mdm.domain.vo.BtypeInfoExcelVO;
import net.lab1024.smartadmin.util.SmartPageUtil;
import net.lab1024.smartadmin.util.SmartBeanUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
public class BtypeInfoService {

    @Autowired
    private BtypeInfoDao btypeInfoDao;

    /**
     * 根据id查询
     */
    public BtypeInfoEntity getById(Long id){
        return  btypeInfoDao.selectById(id);
    }

    /**
     * 分页查询
     * @author ttw
     * @date 2020-10-30 18:12:18
     */
    public ResponseDTO<PageResultDTO<BtypeInfoVO>> queryByPage(BtypeInfoQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<BtypeInfoVO> voList = btypeInfoDao.queryByPage(page, queryDTO);
        PageResultDTO<BtypeInfoVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author ttw
     * @date 2020-10-30 18:12:18
     */
    public ResponseDTO<String> add(BtypeInfoAddDTO addDTO) {
        BtypeInfoEntity entity = SmartBeanUtil.copy(addDTO, BtypeInfoEntity.class);
        btypeInfoDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author ttw
     * @date 2020-10-30 18:12:18
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(BtypeInfoUpdateDTO updateDTO) {
        BtypeInfoEntity entity = SmartBeanUtil.copy(updateDTO, BtypeInfoEntity.class);
        btypeInfoDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author ttw
     * @date 2020-10-30 18:12:18
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<String> idList) {
        btypeInfoDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author ttw
     * @date 2020-10-30 18:12:18
     */
    public List<BtypeInfoExcelVO> queryAllExportData(BtypeInfoQueryDTO queryDTO) {
        return btypeInfoDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author ttw
     * @date 2020-10-30 18:12:18
     */
    public List<BtypeInfoExcelVO> queryBatchExportData(List<String> idList) {
        return btypeInfoDao.queryBatchExportData(idList);
    }

    /**
     * 根据单位类型，查找所有单位
     * @param btypeSortName
     * @return List<BtypeInfoVO>
     */
    public List<BtypeInfoVO> queryBtypeInfoList(String btypeSortName){
        return btypeInfoDao.queryBtypeInfoList(btypeSortName);
    }
}
