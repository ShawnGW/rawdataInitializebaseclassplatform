package com.vtest.it.fttesterdataloginitialtext.service.predeal.impl;

import com.vtest.it.fttesterdataloginitialtext.service.predeal.ListNeedDeal;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

@Service
public class CommonListNeedDealImpl implements ListNeedDeal {
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
                FileUtils.forceDelete(file);
            } catch (Exception e) {
                e.printStackTrace();
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
