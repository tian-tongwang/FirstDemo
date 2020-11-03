package net.lab1024.smartadmin.module.business.scm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.module.business.scm.dao.OrderInfoDao;
import net.lab1024.smartadmin.module.business.scm.domain.dto.OrderInfoAddDTO;
import net.lab1024.smartadmin.module.business.scm.domain.dto.OrderInfoUpdateDTO;
import net.lab1024.smartadmin.module.business.scm.domain.dto.OrderInfoQueryDTO;
import net.lab1024.smartadmin.module.business.scm.domain.dto.OrderInfosAddDTO;
import net.lab1024.smartadmin.module.business.scm.domain.entity.OrderInfoEntity;
import net.lab1024.smartadmin.module.business.scm.domain.vo.OrderInfoVO;
import net.lab1024.smartadmin.module.business.scm.domain.vo.OrderInfoExcelVO;
import net.lab1024.smartadmin.util.SmartPageUtil;
import net.lab1024.smartadmin.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
public class OrderInfoService {

    @Autowired
    private OrderInfoDao orderInfoDao;
    @Autowired
    private OrderInfosService orderInfosService;

    /**
     * 根据id查询
     */
    public OrderInfoEntity getById(String id){
        return  orderInfoDao.selectById(id);
    }

    /**
     * 分页查询
     * @author ttw
     * @date 2020-10-31 15:49:36
     */
    public ResponseDTO<PageResultDTO<OrderInfoVO>> queryByPage(OrderInfoQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<OrderInfoVO> voList = orderInfoDao.queryByPage(page, queryDTO);
        PageResultDTO<OrderInfoVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author ttw
     * @date 2020-10-31 15:49:36
     */
    public ResponseDTO<String> add(OrderInfoAddDTO addDTO) {
        OrderInfoEntity entity = SmartBeanUtil.copy(addDTO, OrderInfoEntity.class);
        //添加逻辑  删除明细

        //判断明细是否为空
        if(addDTO.getOrderBillsList().size() > 0){
            //遍历明细
            for(OrderInfosAddDTO addInfosDTO : addDTO.getOrderBillsList()){
                //设置关联键
                addInfosDTO.setBillCode(addDTO.getBillCode());
                addInfosDTO.setId(addInfosDTO.getBillCode()+"_"+addInfosDTO.getInvCode());
                //调用明细保存方法
                orderInfosService.add(addInfosDTO);
            }
        }
        orderInfoDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author ttw
     * @date 2020-10-31 15:49:36
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(OrderInfoUpdateDTO updateDTO) {
        OrderInfoEntity entity = SmartBeanUtil.copy(updateDTO, OrderInfoEntity.class);
        orderInfoDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author ttw
     * @date 2020-10-31 15:49:36
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<String> idList) {
        orderInfoDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author ttw
     * @date 2020-10-31 15:49:36
     */
    public List<OrderInfoExcelVO> queryAllExportData(OrderInfoQueryDTO queryDTO) {
        return orderInfoDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author ttw
     * @date 2020-10-31 15:49:36
     */
    public List<OrderInfoExcelVO> queryBatchExportData(List<String> idList) {
        return orderInfoDao.queryBatchExportData(idList);
    }
}
