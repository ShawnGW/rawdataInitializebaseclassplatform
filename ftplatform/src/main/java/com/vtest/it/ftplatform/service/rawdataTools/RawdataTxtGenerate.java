package com.vtest.it.ftplatform.service.rawdataTools;

import com.vtest.it.common.pojo.RawDataFtBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@Service
public class RawdataTxtGenerate {

    @Value("${system.properties.tempRawDataPath}")
    private String tempRawDataPath;
    @Autowired
    private RawDataPropertiesInitial rawDataPropertiesInitial;

    public File generateTxt(RawDataFtBean rawDataFtBean, List<String> dieList, Map<Integer, Integer> binSummary,Map<Integer, Integer> SoftBinSummary) throws IOException {
        File file = new File(tempRawDataPath + "/" + rawDataFtBean.getLotId() + "_" + System.currentTimeMillis() + ".raw");
        Map<String, String> map = rawDataPropertiesInitial.initial(rawDataFtBean);
        PrintWriter writer = new PrintWriter(file);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            writer.print(entry.getKey()+":"+entry.getValue()+"\r\n");
        }
        writer.print("RawData\r\n");
        for (String die : dieList) {
            writer.print(die + "\r\n");
        }
        writer.print("DataEnd\r\n");
        writer.print("SkipAndMarkStart\r\n");
        writer.print("SkipAndMarkEnd\r\n");
        writer.print("Hard Bin Summary\r\n");
        for (Map.Entry<Integer, Integer> Entry : binSummary.entrySet()) {
            writer.print("Bin"+Entry.getKey()+":"+Entry.getValue()+"\r\n");
        }
        writer.print("Soft Bin Summary \r\n");
        for (Map.Entry<Integer, Integer> Entry : SoftBinSummary.entrySet()) {
            writer.print("Bin"+Entry.getKey()+":"+Entry.getValue()+"\r\n");
        }
        writer.flush();
        writer.close();
        return file;
    }
}
