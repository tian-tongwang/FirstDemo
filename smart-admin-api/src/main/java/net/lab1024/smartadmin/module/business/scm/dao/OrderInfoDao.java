package net.lab1024.smartadmin.module.business.scm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.lab1024.smartadmin.module.business.scm.domain.dto.OrderInfoQueryDTO;
import net.lab1024.smartadmin.module.business.scm.domain.entity.OrderInfoEntity;
import net.lab1024.smartadmin.module.business.scm.domain.vo.OrderInfoVO;
import net.lab1024.smartadmin.module.business.scm.domain.vo.OrderInfoExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

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
@Mapper
@Component
public interface OrderInfoDao extends BaseMapper<OrderInfoEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return OrderInfoVO
    */
    IPage<OrderInfoVO> queryByPage(Page page, @Param("queryDTO") OrderInfoQueryDTO queryDTO);

    /**
     * 根据id删除
     * @param id
     * @return
    */
    void deleteById(@Param("id") String id);

    /**
     * 根据id批量删除
     * @param idList
     * @return
    */
    void deleteByIdList(@Param("idList") List<String> idList);

        /**
     * 查询所有导出数据
     * @param queryDTO
     * @return
     */
    List<OrderInfoExcelVO> queryAllExportData(@Param("queryDTO") OrderInfoQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<OrderInfoExcelVO> queryBatchExportData(@Param("idList") List<String> idList);
}
