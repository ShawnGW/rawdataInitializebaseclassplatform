package com.vtest.it.fttesterdataloginitialtext.service.predeal.impl;

import com.vtest.it.fttesterdataloginitialtext.service.predeal.ListNeedDeal;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Service
public class CommonListNeedDealImpl implements ListNeedDeal {
    private static final Logger logger = LoggerFactory.getLogger(CommonListNeedDealImpl.class);

    @Override
    public List<File> getStdfListAndDealOthersFile(String path) {
        File[] files = new File(path).listFiles();
        List<File> normalList = new LinkedList<>();
        List<File> zipList = new LinkedList<>();
        List<File> tempList = new LinkedList<>();
        for (File file : files) {
            String fileName = file.getName();
            if (fileName.endsWith(".zip")) {
                zipList.add(file);
                continue;
            }
            if (fileName.endsWith(".temp")) {
                tempList.add(file);
                continue;
            }
            if (checkLastModifyTime(file, 120)) {
                normalList.add(file);
            }
        }
        File target = new File(path);
        for (File file : zipList) {
            try {
                ZipUtil.unpack(file, target);
            } catch (Exception e) {
                logger.error(file.getName());
                logger.error("there are error in this "+file.getName()+" has been deleted!");
                e.printStackTrace();
            }finally {
                try {
                    FileUtils.forceDelete(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return normalList;
    }

    public boolean checkLastModifyTime(File file, int seconds) {
        long currentTime = System.currentTimeMillis();
        long fileLastModifyTime = file.lastModified();
        if (((currentTime - fileLastModifyTime) / 1000) > seconds) {
            return true;
        }
        return false;

    }
}
