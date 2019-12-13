package com.vtest.it.ftplatform.service.rawdataTools;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class RawDataRelease {
    public void release(File sourceFile,String path,String rightName){
        try {
            File destFile=new File(path+"/"+rightName);
            FileUtils.copyFile(sourceFile,destFile);
            if (DiffUtil.check(sourceFile,destFile)){
                FileUtils.forceDelete(sourceFile);
            }else {
                release(sourceFile,path,rightName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
