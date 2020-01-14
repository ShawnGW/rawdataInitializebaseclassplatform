package com.vtest.it.fttesterdataloginitialtext.service.stdfNameParse.impl;

import com.vtest.it.fttesterdataloginitialtext.pojo.StdfInformationBean;
import com.vtest.it.fttesterdataloginitialtext.service.stdfNameParse.StdfParser;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class J750StdfParserImpl implements StdfParser {

    private static final String regex = "VTEST_FT_(\\w{3})_([\\.\\w-]{1,}|[\\.\\w-_\\(\\)]{1,})_([A-Z0-9-\\.]{1,})_([\\w-\\.]{1,})_(TT[A-Z]{1}-[\\dA-Z]{2,4})_([0-9A-Z-]{1,})_([\\w-_]{1,})_(F[\\w0-9]{1,})_(RP[0-9]{1})_([Vv]{1}[0-9]{3,}|[0-9]{4,})_([0-9]{8}_[0-9]{6})\\.([A-Za-z0-9]{1,})";

    @Override
    public StdfInformationBean parse(File file) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(file.getName());
        if (matcher.find()) {
            StdfInformationBean bean = new StdfInformationBean();
            String customerCode = matcher.group(1);
            String device = matcher.group(2);
            String lot = matcher.group(3);
            String vLot = matcher.group(4);
            String tester = matcher.group(5);
            String handler = matcher.group(6);
            String loadBoard = matcher.group(7);
            String ftStep = matcher.group(8);
            String rpStep = matcher.group(9);
            String operator = matcher.group(10);
            String testTime = matcher.group(11);
            String suffix = matcher.group(12);

            bean.setCustomerCode(customerCode);
            bean.setDevice(device);
            bean.setLot(lot);
            bean.setVLot(vLot);
            bean.setTester(tester);
            bean.setHandler(handler);
            bean.setFtStep(ftStep);
            bean.setLoadBoard(loadBoard);
            bean.setRpStep(rpStep);
            bean.setOperator(operator);
            bean.setStartTime(testTime);
            bean.setSuffix(suffix);
            return bean;
        }
        return null;
    }
}
