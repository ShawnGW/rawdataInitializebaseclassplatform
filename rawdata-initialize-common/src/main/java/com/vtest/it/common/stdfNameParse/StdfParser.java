package com.vtest.it.common.stdfNameParse;


import com.vtest.it.common.pojo.StdfInformationBean;

import java.io.File;

public interface StdfParser {
    public StdfInformationBean parse(File file);
}
