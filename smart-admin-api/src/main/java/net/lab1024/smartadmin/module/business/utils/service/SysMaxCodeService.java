package net.lab1024.smartadmin.module.business.utils.service;


import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.module.business.utils.dao.SysMaxCodeDao;
import net.lab1024.smartadmin.module.business.utils.domain.entity.SysMaxCodeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
public class SysMaxCodeService {

    @Autowired
    private SysMaxCodeDao sysMaxCodeDao;

    /**
     * 根据id查询
     */
    public SysMaxCodeEntity getById(String id){
        return  sysMaxCodeDao.selectById(id);
    }


    /**
     * 添加
     * @author ttw
     * @date 2020-10-31 14:55:56
     */
    public ResponseDTO<String> add(SysMaxCodeEntity entity) {
        sysMaxCodeDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author ttw
     * @date 2020-10-31 14:55:56
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(SysMaxCodeEntity entity) {
        sysMaxCodeDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author ttw
     * @date 2020-10-31 14:55:56
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteById(String id) {
        sysMaxCodeDao.deleteById(id);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author ttw
     * @date 2020-10-31 14:55:56
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<String> idList) {
        sysMaxCodeDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }
}
