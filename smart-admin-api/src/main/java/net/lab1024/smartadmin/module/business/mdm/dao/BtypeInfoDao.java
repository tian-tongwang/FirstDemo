package net.lab1024.smartadmin.module.business.mdm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.lab1024.smartadmin.module.business.mdm.domain.dto.BtypeInfoQueryDTO;
import net.lab1024.smartadmin.module.business.mdm.domain.entity.BtypeInfoEntity;
import net.lab1024.smartadmin.module.business.mdm.domain.vo.BtypeInfoVO;
import net.lab1024.smartadmin.module.business.mdm.domain.vo.BtypeInfoExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

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
@Mapper
@Component
public interface BtypeInfoDao extends BaseMapper<BtypeInfoEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return BtypeInfoVO
    */
    IPage<BtypeInfoVO> queryByPage(Page page, @Param("queryDTO") BtypeInfoQueryDTO queryDTO);

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
    List<BtypeInfoExcelVO> queryAllExportData(@Param("queryDTO") BtypeInfoQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<BtypeInfoExcelVO> queryBatchExportData(@Param("idList") List<String> idList);

    /**
     * 根据单位类型，查找所有单位
     * @param btypeSortName
     * @return List<BtypeInfoVO>
     */
    List<BtypeInfoVO> queryBtypeInfoList(@Param("btypeSortName") String btypeSortName);
}
