package net.lab1024.smartadmin.module.business.mdm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.lab1024.smartadmin.module.business.mdm.domain.dto.WarehouseInfoQueryDTO;
import net.lab1024.smartadmin.module.business.mdm.domain.entity.WarehouseInfoEntity;
import net.lab1024.smartadmin.module.business.mdm.domain.vo.WarehouseInfoVO;
import net.lab1024.smartadmin.module.business.mdm.domain.vo.WarehouseInfoExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

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
@Mapper
@Component
public interface WarehouseInfoDao extends BaseMapper<WarehouseInfoEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return WarehouseInfoVO
    */
    IPage<WarehouseInfoVO> queryByPage(Page page, @Param("queryDTO") WarehouseInfoQueryDTO queryDTO);

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
    List<WarehouseInfoExcelVO> queryAllExportData(@Param("queryDTO") WarehouseInfoQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<WarehouseInfoExcelVO> queryBatchExportData(@Param("idList") List<String> idList);

    /**
     * 查找所有仓库
     * @return
     */
    List<WarehouseInfoVO> queryWareHouseList();
}
