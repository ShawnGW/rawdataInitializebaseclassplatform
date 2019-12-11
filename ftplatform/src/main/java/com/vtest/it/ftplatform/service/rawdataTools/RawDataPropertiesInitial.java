package com.vtest.it.ftplatform.service.rawdataTools;

import com.vtest.it.common.pojo.RawDataFtBean;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class RawDataPropertiesInitial {
    public Map<String,String> initial(RawDataFtBean rawDataFtBean){
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map<String,String> map=new LinkedHashMap<>(100);
        map.put("Lot ID",rawDataFtBean.getLotId());
        map.put("Inner MotherLot",rawDataFtBean.getInnerMotherLot());
        map.put("Customer Code",rawDataFtBean.getCustomerCode());
        map.put("Device Name",rawDataFtBean.getDeviceName());
        map.put("Wafer ID",rawDataFtBean.getWaferId());
        map.put("Lot Start Time",rawDataFtBean.getLotStartTime().toString());
        map.put("PE Owner",rawDataFtBean.getPeOwner());
        map.put("Tester SoftWare Revision",rawDataFtBean.getTesterSoftwareRevision());
        map.put("Tester Model",rawDataFtBean.getTesterModel());
        map.put("Chinese Name",rawDataFtBean.getChineseName());
        map.put("Chines Short Name",rawDataFtBean.getChineseShortName());
        map.put("Part Num",rawDataFtBean.getPartNum());
        map.put("Process SPEC",rawDataFtBean.getProcessSpec());
        map.put("Process Revision",rawDataFtBean.getProcessRevision());
        map.put("Worker Order",rawDataFtBean.getWorkerOrder());
        map.put("Lot Status",rawDataFtBean.getLotStatus());
        map.put("Wip Stage",rawDataFtBean.getWipStage());
        map.put("Wip Step",rawDataFtBean.getWipStep());
        map.put("PO Number",rawDataFtBean.getPoNumber());
        map.put("CTC PO Number",rawDataFtBean.getCtcPoNumber());
        map.put("Part DESC",rawDataFtBean.getPartDesc());
        map.put("Is OTP",String.valueOf(rawDataFtBean.isOtp()));
        map.put("Is COP",String.valueOf(rawDataFtBean.isCop()));
        map.put("Fab Device",rawDataFtBean.getFabDevice());
        map.put("Asy Device",rawDataFtBean.getAsyDevice());
        map.put("Is Trimed",String.valueOf(rawDataFtBean.isTrimed()));
        map.put("Load File",rawDataFtBean.getLoadFile());
        map.put("Customer Test Spec",rawDataFtBean.getCustomerTestSpec());
        map.put("Process Short Flow",rawDataFtBean.getProcessShortFlow());
        map.put("Load Bord",rawDataFtBean.getLoadBord());
        map.put("Socket Number",String.valueOf(rawDataFtBean.getSocketNumber()));
        map.put("shipLot",rawDataFtBean.getShipLot());
        map.put("Sites",String.valueOf(rawDataFtBean.getSites()));
        map.put("Site To Site",rawDataFtBean.getSiteToSite());
        map.put("Continue Fail",rawDataFtBean.getContinueFail());
        map.put("Handel Device",rawDataFtBean.getHandelDevice());
        map.put("Operator",rawDataFtBean.getOperator());
        map.put("Tester Program",rawDataFtBean.getTesterProgram());
        map.put("ALL FT Programs",rawDataFtBean.getAllFtPrograms());
        map.put("Tester ID",rawDataFtBean.getTesterId());
        map.put("Handel ID",rawDataFtBean.getHandelId());
        map.put("FT Process",rawDataFtBean.getFtProcess());
        map.put("Hold Count",String.valueOf(rawDataFtBean.getHoldCount()));
        map.put("Test Start Time",format.format(rawDataFtBean.getTestStartTime().getTime()));
        map.put("Test End Time",format.format(rawDataFtBean.getTestEndTime().getTime()));
        map.put("Pass Die",String.valueOf(rawDataFtBean.getPassDie()));
        map.put("Fail Die",String.valueOf(rawDataFtBean.getFailDie()));
        map.put("Lot Yield",String.format("%.2f",(rawDataFtBean.getLotYield()*100)));
        map.put("Stop Yield",String.valueOf(rawDataFtBean.getStopYield()));
        map.put("Major Fail",rawDataFtBean.getMajorFail());
        map.put("Process Yield",rawDataFtBean.getProcessYield());
        map.put("Ft Yields",rawDataFtBean.getFtYield());
        map.put("Pass Bins",rawDataFtBean.getPassBins());
        map.put("OS Bins",rawDataFtBean.getOsBins());
        map.put("Special Bins",rawDataFtBean.getSpecialBins());
        map.put("DataBase",rawDataFtBean.getDataBase());
        map.put("TestTime",rawDataFtBean.getTestTime());
        map.put("PKG",rawDataFtBean.getPkg());
        map.put("GPIB_Bin",String.valueOf(rawDataFtBean.getGpibBin()));
        return map;
    }
}
