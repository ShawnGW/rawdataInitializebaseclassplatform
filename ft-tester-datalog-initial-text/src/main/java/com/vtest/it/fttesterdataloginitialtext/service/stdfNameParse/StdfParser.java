package com.vtest.it.fttesterdataloginitialtext.service.stdfNameParse;

import com.vtest.it.fttesterdataloginitialtext.pojo.StdfInformationBean;

import java.io.File;

public interface StdfParser {
    public StdfInformationBean parse(File file);
}
