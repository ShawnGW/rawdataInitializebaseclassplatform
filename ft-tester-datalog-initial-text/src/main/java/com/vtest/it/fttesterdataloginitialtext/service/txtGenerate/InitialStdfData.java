package com.vtest.it.fttesterdataloginitialtext.service.txtGenerate;

import com.vtest.it.fttesterdataloginitialtext.pojo.StdfInformationBean;
import com.vtest.it.fttesterdataloginitialtext.service.predeal.impl.CommonListNeedDealImpl;
import com.vtest.it.fttesterdataloginitialtext.service.stdfNameParse.StdfParser;
import com.vtest.it.fttesterdataloginitialtext.service.stdfNameParse.impl.J750StdfParserImpl;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InitialStdfData {

    private static final Logger logger = LoggerFactory.getLogger(InitialStdfData.class);

    @Value("${system.properties.source-j750}")
    private String j750SourcePath;
    @Value("${system.properties.source-v93000}")
    private String v93kSourcePath;
    @Value("${system.properties.target}")
    private String targetPath;
    @Value("${system.properties.backup}")
    private String backupPath;

    @Autowired
    private J750StdfParserImpl J750StdfParserImpl;
    @Autowired
    private CommonListNeedDealImpl commonListNeedDeal;

    private static final String STDFREADER = "/scripts/STDFreader ";

    @Scheduled(fixedRate = 200)
    public void initial() throws IOException {
        Map< List<File>,StdfParser> totalList = new HashMap<>();

        List<File> j750List = commonListNeedDeal.getStdfListAndDealOthersFile(j750SourcePath);
        List<File> v93kList = commonListNeedDeal.getStdfListAndDealOthersFile(v93kSourcePath);
        totalList.put(j750List,J750StdfParserImpl);
        totalList.put(v93kList,J750StdfParserImpl);
        for (Map.Entry<List<File>,StdfParser> stdfParserListEntry : totalList.entrySet()) {
            List<File> list = stdfParserListEntry.getKey();
            StdfParser parser = stdfParserListEntry.getValue();
            for (File stdf : list) {
                try {
                    StdfInformationBean stdfInformationBean = parser.parse(stdf);
                    String customerCode = stdfInformationBean.getCustomerCode();
                    String device = stdfInformationBean.getDevice();
                    String lot = stdfInformationBean.getLot();
                    String ftStep = stdfInformationBean.getFtStep();
                    String vLot = stdfInformationBean.getVLot();

                    File targetDirectory = new File(backupPath + "/" + customerCode + "/" + device + "/" + lot + "/" + vLot + "/" + ftStep);
                    if (!targetDirectory.exists()) {
                        targetDirectory.mkdirs();
                    }
                    File targetFile = new File(targetDirectory.getPath() + "/" + stdf.getName());
                    FileUtils.copyFile(stdf, targetFile);
                    FileUtils.forceDelete(stdf);
                    if (stdf.getName().endsWith(".stdf")) {
                        File directory = new File(targetPath + "/" + customerCode + "/" + device + "/" + lot + "/" + vLot + "/" + ftStep);
                        if (!directory.exists()) {
                            directory.mkdirs();
                        }
                        File stdfTxt = new File(directory.getPath() + "/" + stdf.getName() + ".txt");
                        String CMD = STDFREADER + targetFile + " > " + stdfTxt;
                        Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", CMD});
                    }
                    logger.info(stdf.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error(stdf.getName() + " has occur error!");
                }
            }
        }
    }
}
