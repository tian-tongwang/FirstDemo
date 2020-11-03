package net.lab1024.smartadmin.module.business.common;

import net.lab1024.smartadmin.module.business.utils.domain.entity.SysMaxCodeEntity;
import net.lab1024.smartadmin.module.business.utils.service.SysMaxCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class BillTypeUtils {

    @Autowired
    private SysMaxCodeService sysMaxCodeService;

    /**
     * 订单类型编码
     */
    public final String XS = "XS";
    public final String CG = "CG";
    public final String RK = "RK";
    public final String CK = "CK";

    /**
     * 根据订单类型编码返回订单类型名称
     * @param billType
     * @return billTypeName
     */
    public String BillTypeName(String billType){
        String billTypeName = null;
        switch (billType){
            case "XS":
                billTypeName = "销售单";
                break;
            case "CG":
                billTypeName = "采购单";
                break;
            case "RK":
                billTypeName = "入库单";
                break;
            case "CK":
                billTypeName = "出库单";
                break;
        }
        return billTypeName;
    }

    /**
     * 根据订单类型返回订单号
     * @param billType
     * @return billCode
     */
    public String getMaxBillCode(String billType){
        String billCode = null;
        SysMaxCodeEntity sysMaxCodeEntity = sysMaxCodeService.getById(billType);
        if(null != sysMaxCodeEntity && !"".equals(sysMaxCodeEntity)){
            Integer OriYear = Integer.valueOf(sysMaxCodeEntity.getYear());
            Integer nowYear = Calendar.getInstance().get(Calendar.YEAR);
            if( !nowYear.equals(OriYear)){
                sysMaxCodeService.deleteById(sysMaxCodeEntity.getBillType());
                sysMaxCodeEntity.setBillType(billType);
                sysMaxCodeEntity.setYear(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
                sysMaxCodeEntity.setMaxCode(1);
                sysMaxCodeService.add(sysMaxCodeEntity);
                sysMaxCodeEntity = sysMaxCodeService.getById(billType);
            }
        }else{
            sysMaxCodeEntity = new SysMaxCodeEntity();
            sysMaxCodeEntity.setBillType(billType);
            sysMaxCodeEntity.setYear(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
            sysMaxCodeEntity.setMaxCode(1);
            sysMaxCodeService.add(sysMaxCodeEntity);
            sysMaxCodeEntity = sysMaxCodeService.getById(billType);
        }
        billCode = billType+sysMaxCodeEntity.getYear()+String.format("%5d", sysMaxCodeEntity.getMaxCode()).replace(" ", "0");
        sysMaxCodeEntity.setMaxCode(sysMaxCodeEntity.getMaxCode()+1);
        sysMaxCodeService.update(sysMaxCodeEntity);
        return billCode;
    }
}
