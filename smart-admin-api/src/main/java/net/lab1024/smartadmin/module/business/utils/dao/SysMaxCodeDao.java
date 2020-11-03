package net.lab1024.smartadmin.module.business.utils.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.lab1024.smartadmin.module.business.utils.domain.entity.SysMaxCodeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 最大单号记录 ]
 *
 * @author ttw
 * @version 1.0
 * @company 
 * @copyright (c)  Inc. All rights reserved.
 * @date 2020-10-31 14:55:56
 * @since JDK1.8
 */
@Mapper
@Component
public interface SysMaxCodeDao extends BaseMapper<SysMaxCodeEntity> {

    /**
     * 根据id删除
     * @param id
     * @return
    */
    void deleteById(@Param("id")String id);

    /**
     * 根据id批量删除
     * @param idList
     * @return
    */
    void deleteByIdList(@Param("idList") List<String> idList);
}
