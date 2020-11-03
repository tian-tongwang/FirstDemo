package net.lab1024.smartadmin.module.business.mdm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.lab1024.smartadmin.module.business.mdm.domain.dto.InventoryInfoQueryDTO;
import net.lab1024.smartadmin.module.business.mdm.domain.entity.InventoryInfoEntity;
import net.lab1024.smartadmin.module.business.mdm.domain.vo.InventoryInfoVO;
import net.lab1024.smartadmin.module.business.mdm.domain.vo.InventoryInfoExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

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
@Mapper
@Component
public interface InventoryInfoDao extends BaseMapper<InventoryInfoEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return InventoryInfoVO
    */
    IPage<InventoryInfoVO> queryByPage(Page page, @Param("queryDTO") InventoryInfoQueryDTO queryDTO);

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
    void deleteByIdList(@Param("idList") List<String> idList);

        /**
     * 查询所有导出数据
     * @param queryDTO
     * @return
     */
    List<InventoryInfoExcelVO> queryAllExportData(@Param("queryDTO") InventoryInfoQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<InventoryInfoExcelVO> queryBatchExportData(@Param("idList") List<String> idList);

    /**
     * 查询所有分类信息
     * @return list
     */
    List<InventoryInfoVO> querySortInfo();

    /**
     * 查询所有品牌信息
     * @return
     */
    List<InventoryInfoVO> queryBrandInfo();
}
