package com.vtest.it.common.pojo;


import java.io.Serializable;

public class StdfInformationBean implements Serializable {
    private static final long serialVersionUID = 1l;
    private String customerCode;
    private String device;
    private String lot;
    private String vLot;
    private String tester;
    private String handler;
    private String loadBoard;
    private String ftStep;
    private String rpStep;
    private String operator;
    private String startTime;
    private String suffix;

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public String getvLot() {
        return vLot;
    }

    public void setvLot(String vLot) {
        this.vLot = vLot;
    }

    public String getTester() {
        return tester;
    }

    public void setTester(String tester) {
        this.tester = tester;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public String getLoadBoard() {
        return loadBoard;
    }

    public void setLoadBoard(String loadBoard) {
        this.loadBoard = loadBoard;
    }

    public String getFtStep() {
        return ftStep;
    }

    public void setFtStep(String ftStep) {
        this.ftStep = ftStep;
    }

    public String getRpStep() {
        return rpStep;
    }

    public void setRpStep(String rpStep) {
        this.rpStep = rpStep;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
