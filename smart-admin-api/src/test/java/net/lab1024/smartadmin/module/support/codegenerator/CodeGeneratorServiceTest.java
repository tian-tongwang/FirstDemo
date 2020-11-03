package net.lab1024.smartadmin.module.support.codegenerator;

import net.lab1024.smartadmin.BaseTest;
import net.lab1024.smartadmin.module.support.codegenerator.constant.SqlOperateTypeEnum;
import net.lab1024.smartadmin.module.support.codegenerator.domain.CodeGeneratorDTO;
import net.lab1024.smartadmin.module.support.codegenerator.domain.CodeGeneratorQueryColumnDTO;
import net.lab1024.smartadmin.module.support.codegenerator.service.CodeGeneratorService;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * IdGeneratorService Tester.
 *
 * @author zhuoda
 * @version 1.0
 */
public class CodeGeneratorServiceTest extends BaseTest {

    @Autowired
    private CodeGeneratorService codeGeneratorService;

    @Test
    public void testGenerate() throws Exception {
        /**
         * !!! 所有查询条件均包含了createTime和updateTime的 范围查询 !!!
         */

        // t_inventory_info 商品信息表

        //搜索字段 billType， 使用like搜索
        CodeGeneratorQueryColumnDTO invCode = CodeGeneratorQueryColumnDTO.builder()
                .columnName("inv_code")
                .sqlOperate(SqlOperateTypeEnum.EQUALS).build();
        CodeGeneratorQueryColumnDTO invName = CodeGeneratorQueryColumnDTO.builder()
                .columnName("inv_name")
                .sqlOperate(SqlOperateTypeEnum.EQUALS).build();
        CodeGeneratorQueryColumnDTO invUnit = CodeGeneratorQueryColumnDTO.builder()
                .columnName("inv_unit")
                .sqlOperate(SqlOperateTypeEnum.EQUALS).build();
        CodeGeneratorQueryColumnDTO qty = CodeGeneratorQueryColumnDTO.builder()
                .columnName("qty")
                .sqlOperate(SqlOperateTypeEnum.EQUALS).build();
        CodeGeneratorQueryColumnDTO price = CodeGeneratorQueryColumnDTO.builder()
                .columnName("price")
                .sqlOperate(SqlOperateTypeEnum.EQUALS).build();
        CodeGeneratorQueryColumnDTO sumMoney = CodeGeneratorQueryColumnDTO.builder()
                .columnName("sum_money")
                .sqlOperate(SqlOperateTypeEnum.EQUALS).build();
        CodeGeneratorQueryColumnDTO discountMoney = CodeGeneratorQueryColumnDTO.builder()
                .columnName("discount_money")
                .sqlOperate(SqlOperateTypeEnum.EQUALS).build();
        CodeGeneratorQueryColumnDTO costMoney = CodeGeneratorQueryColumnDTO.builder()
                .columnName("cost_money")
                .sqlOperate(SqlOperateTypeEnum.EQUALS).build();
        CodeGeneratorQueryColumnDTO id = CodeGeneratorQueryColumnDTO.builder()
                .columnName("id")
                .sqlOperate(SqlOperateTypeEnum.EQUALS).build();
        CodeGeneratorQueryColumnDTO billCode = CodeGeneratorQueryColumnDTO.builder()
                .columnName("bill_code")
                .sqlOperate(SqlOperateTypeEnum.EQUALS).build();
        List<CodeGeneratorQueryColumnDTO> queryColumnList = Lists.newArrayList(invCode,invName,invUnit,qty,price,sumMoney,discountMoney,costMoney,id,billCode);

        CodeGeneratorDTO codeGenerator = CodeGeneratorDTO.builder()
                .author("ttw")//class 注释作者
                .company("")//class注释公司名字
                .tableName("t_order_infos")//表名
                .tablePrefix("t_")//表名前缀
                .basePackage("net.lab1024.smartadmin")//包名
                .modulePackage("business.scm")//业务子包名
                .queryColumnList(queryColumnList)//加入搜搜字段
                .build();//构建

        //当需要代码生成的时候，请将注释去掉
        codeGeneratorService.codeGenerator(codeGenerator);
    }

}
