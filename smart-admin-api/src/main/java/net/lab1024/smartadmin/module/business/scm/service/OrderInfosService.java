package net.lab1024.smartadmin.module.business.scm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.module.business.scm.dao.OrderInfosDao;
import net.lab1024.smartadmin.module.business.scm.domain.dto.OrderInfosAddDTO;
import net.lab1024.smartadmin.module.business.scm.domain.dto.OrderInfosUpdateDTO;
import net.lab1024.smartadmin.module.business.scm.domain.dto.OrderInfosQueryDTO;
import net.lab1024.smartadmin.module.business.scm.domain.entity.OrderInfosEntity;
import net.lab1024.smartadmin.module.business.scm.domain.vo.OrderInfosVO;
import net.lab1024.smartadmin.module.business.scm.domain.vo.OrderInfosExcelVO;
import net.lab1024.smartadmin.util.SmartPageUtil;
import net.lab1024.smartadmin.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
public class OrderInfosService {

    @Autowired
    private OrderInfosDao orderInfosDao;

    /**
     * 根据id查询
     */
    public OrderInfosEntity getById(Long id){
        return  orderInfosDao.selectById(id);
    }

    /**
     * 分页查询
     * @author ttw
     * @date 2020-11-03 21:03:34
     */
    public ResponseDTO<PageResultDTO<OrderInfosVO>> queryByPage(OrderInfosQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<OrderInfosVO> voList = orderInfosDao.queryByPage(page, queryDTO);
        PageResultDTO<OrderInfosVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author ttw
     * @date 2020-11-03 21:03:34
     */
    public ResponseDTO<String> add(OrderInfosAddDTO addDTO) {
        OrderInfosEntity entity = SmartBeanUtil.copy(addDTO, OrderInfosEntity.class);
        orderInfosDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author ttw
     * @date 2020-11-03 21:03:34
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(OrderInfosUpdateDTO updateDTO) {
        OrderInfosEntity entity = SmartBeanUtil.copy(updateDTO, OrderInfosEntity.class);
        orderInfosDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author ttw
     * @date 2020-11-03 21:03:34
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        orderInfosDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author ttw
     * @date 2020-11-03 21:03:34
     */
    public List<OrderInfosExcelVO> queryAllExportData(OrderInfosQueryDTO queryDTO) {
        return orderInfosDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author ttw
     * @date 2020-11-03 21:03:34
     */
    public List<OrderInfosExcelVO> queryBatchExportData(List<Long> idList) {
        return orderInfosDao.queryBatchExportData(idList);
    }
}
