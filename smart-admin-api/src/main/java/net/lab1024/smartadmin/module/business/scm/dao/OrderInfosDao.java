package net.lab1024.smartadmin.module.business.scm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.lab1024.smartadmin.module.business.scm.domain.dto.OrderInfosQueryDTO;
import net.lab1024.smartadmin.module.business.scm.domain.entity.OrderInfosEntity;
import net.lab1024.smartadmin.module.business.scm.domain.vo.OrderInfosVO;
import net.lab1024.smartadmin.module.business.scm.domain.vo.OrderInfosExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

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
@Mapper
@Component
public interface OrderInfosDao extends BaseMapper<OrderInfosEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return OrderInfosVO
    */
    IPage<OrderInfosVO> queryByPage(Page page, @Param("queryDTO") OrderInfosQueryDTO queryDTO);

    /**
     * 根据id删除
     * @param id
     * @return
    */
    void deleteById(@Param("id") Long id);

    /**
     * 根据id批量删除
     * @param idList
     * @return
    */
    void deleteByIdList(@Param("idList") List<Long> idList);

        /**
     * 查询所有导出数据
     * @param queryDTO
     * @return
     */
    List<OrderInfosExcelVO> queryAllExportData(@Param("queryDTO") OrderInfosQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<OrderInfosExcelVO> queryBatchExportData(@Param("idList") List<Long> idList);
}
