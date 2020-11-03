package net.lab1024.smartadmin.module.business.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import net.lab1024.smartadmin.module.system.login.domain.RequestTokenBO;
import net.lab1024.smartadmin.util.SmartRequestTokenUtil;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MetaHandler implements MetaObjectHandler {
    /*
    * 新增数据时执行
    * */
    @Override
    public void insertFill(MetaObject metaObject) {
        //获取用户信息
        RequestTokenBO requestToken = SmartRequestTokenUtil.getRequestUser();
        this.setFieldValByName("createBy",requestToken.getEmployeeBO().getActualName(),metaObject);
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateBy",requestToken.getEmployeeBO().getActualName(),metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }

    /*更新数据时执行*/
    @Override
    public void updateFill(MetaObject metaObject) {
        //获取用户信息
        RequestTokenBO requestToken = SmartRequestTokenUtil.getRequestUser();
        this.setFieldValByName("updateBy",requestToken.getEmployeeBO().getActualName(),metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
