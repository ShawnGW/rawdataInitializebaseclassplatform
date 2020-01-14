package com.vtest.it.fttesterdataloginitialtext.service.predeal;

import com.vtest.it.fttesterdataloginitialtext.service.stdfNameParse.StdfParser;

import java.io.File;
import java.util.List;

public interface ListNeedDeal {
    public List<File> getStdfListAndDealOthersFile(String path);
}
