package com.vtest.it.common.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RawDataFtBean implements Serializable {
    private static final long serialVersionUID=1L;
    private String lotId;
    private String innerMotherLot;
    private String customerCode;
    private String deviceName;
    private String waferId;
    private Date lotStartTime;
    private String peOwner;
    private String testerSoftwareRevision;
    private String testerModel;
    private String chineseName;
    private String chineseShortName;
    private String partNum;
    private String processSpec;
    private String processRevision;
    private String workerOrder;
    private String lotStatus;
    private String wipStage;
    private String wipStep;
    private String poNumber;
    private String ctcPoNumber;
    private String partDesc;
    private boolean isOtp;
    private boolean isCop;
    private String fabDevice;
    private String asyDevice;
    private boolean isTrimed;
    private String loadFile;
    private String customerTestSpec;
    private String processShortFlow;
    private String loadBord;
    private int socketNumber;
    private String shipLot;
    private int sites;
    private String siteToSite;
    private String continueFail;
    private String handelDevice;
    private String operator;
    private String testerProgram;
    private String stdfProgram;
    private String allFtPrograms;
    private String testerId;
    private String handelId;
    private String ftProcess;
    private int holdCount;
    private Date testStartTime;
    private Date testEndTime;
    private int passDie;
    private int failDie;
    private double lotYield;
    private double stopYield;
    private String majorFail;
    private String processYield;
    private String ftYield;
    private String passBins;
    private String osBins;
    private String specialBins;
    private String dataBase;
    private String testTime;
    private String pkg;
    private int gpibBin;
    private List<String> list;

    public String getLotId() {
        return lotId;
    }

    public void setLotId(String lotId) {
        this.lotId = lotId;
    }

    public String getInnerMotherLot() {
        return innerMotherLot;
    }

    public void setInnerMotherLot(String innerMotherLot) {
        this.innerMotherLot = innerMotherLot;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getWaferId() {
        return waferId;
    }

    public void setWaferId(String waferId) {
        this.waferId = waferId;
    }

    public Date getLotStartTime() {
        return lotStartTime;
    }

    public void setLotStartTime(Date lotStartTime) {
        this.lotStartTime = lotStartTime;
    }

    public String getPeOwner() {
        return peOwner;
    }

    public void setPeOwner(String peOwner) {
        this.peOwner = peOwner;
    }

    public String getTesterSoftwareRevision() {
        return testerSoftwareRevision;
    }

    public void setTesterSoftwareRevision(String testerSoftwareRevision) {
        this.testerSoftwareRevision = testerSoftwareRevision;
    }

    public String getTesterModel() {
        return testerModel;
    }

    public void setTesterModel(String testerModel) {
        this.testerModel = testerModel;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getChineseShortName() {
        return chineseShortName;
    }

    public void setChineseShortName(String chineseShortName) {
        this.chineseShortName = chineseShortName;
    }

    public String getPartNum() {
        return partNum;
    }

    public void setPartNum(String partNum) {
        this.partNum = partNum;
    }

    public String getProcessSpec() {
        return processSpec;
    }

    public void setProcessSpec(String processSpec) {
        this.processSpec = processSpec;
    }

    public String getProcessRevision() {
        return processRevision;
    }

    public void setProcessRevision(String processRevision) {
        this.processRevision = processRevision;
    }

    public String getWorkerOrder() {
        return workerOrder;
    }

    public void setWorkerOrder(String workerOrder) {
        this.workerOrder = workerOrder;
    }

    public String getLotStatus() {
        return lotStatus;
    }

    public void setLotStatus(String lotStatus) {
        this.lotStatus = lotStatus;
    }

    public String getWipStage() {
        return wipStage;
    }

    public void setWipStage(String wipStage) {
        this.wipStage = wipStage;
    }

    public String getWipStep() {
        return wipStep;
    }

    public void setWipStep(String wipStep) {
        this.wipStep = wipStep;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getCtcPoNumber() {
        return ctcPoNumber;
    }

    public void setCtcPoNumber(String ctcPoNumber) {
        this.ctcPoNumber = ctcPoNumber;
    }

    public String getPartDesc() {
        return partDesc;
    }

    public void setPartDesc(String partDesc) {
        this.partDesc = partDesc;
    }

    public boolean isOtp() {
        return isOtp;
    }

    public void setOtp(boolean otp) {
        isOtp = otp;
    }

    public boolean isCop() {
        return isCop;
    }

    public void setCop(boolean cop) {
        isCop = cop;
    }

    public String getFabDevice() {
        return fabDevice;
    }

    public void setFabDevice(String fabDevice) {
        this.fabDevice = fabDevice;
    }

    public String getAsyDevice() {
        return asyDevice;
    }

    public void setAsyDevice(String asyDevice) {
        this.asyDevice = asyDevice;
    }

    public boolean isTrimed() {
        return isTrimed;
    }

    public void setTrimed(boolean trimed) {
        isTrimed = trimed;
    }

    public String getLoadFile() {
        return loadFile;
    }

    public void setLoadFile(String loadFile) {
        this.loadFile = loadFile;
    }

    public String getCustomerTestSpec() {
        return customerTestSpec;
    }

    public void setCustomerTestSpec(String customerTestSpec) {
        this.customerTestSpec = customerTestSpec;
    }

    public String getProcessShortFlow() {
        return processShortFlow;
    }

    public void setProcessShortFlow(String processShortFlow) {
        this.processShortFlow = processShortFlow;
    }

    public String getLoadBord() {
        return loadBord;
    }

    public void setLoadBord(String loadBord) {
        this.loadBord = loadBord;
    }

    public int getSocketNumber() {
        return socketNumber;
    }

    public void setSocketNumber(int socketNumber) {
        this.socketNumber = socketNumber;
    }

    public String getShipLot() {
        return shipLot;
    }

    public void setShipLot(String shipLot) {
        this.shipLot = shipLot;
    }

    public int getSites() {
        return sites;
    }

    public void setSites(int sites) {
        this.sites = sites;
    }

    public String getSiteToSite() {
        return siteToSite;
    }

    public void setSiteToSite(String siteToSite) {
        this.siteToSite = siteToSite;
    }

    public String getContinueFail() {
        return continueFail;
    }

    public void setContinueFail(String continueFail) {
        this.continueFail = continueFail;
    }

    public String getHandelDevice() {
        return handelDevice;
    }

    public void setHandelDevice(String handelDevice) {
        this.handelDevice = handelDevice;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getTesterProgram() {
        return testerProgram;
    }

    public void setTesterProgram(String testerProgram) {
        this.testerProgram = testerProgram;
    }

    public String getStdfProgram() {
        return stdfProgram;
    }

    public void setStdfProgram(String stdfProgram) {
        this.stdfProgram = stdfProgram;
    }

    public String getAllFtPrograms() {
        return allFtPrograms;
    }

    public void setAllFtPrograms(String allFtPrograms) {
        this.allFtPrograms = allFtPrograms;
    }

    public String getTesterId() {
        return testerId;
    }

    public void setTesterId(String testerId) {
        this.testerId = testerId;
    }

    public String getHandelId() {
        return handelId;
    }

    public void setHandelId(String handelId) {
        this.handelId = handelId;
    }

    public String getFtProcess() {
        return ftProcess;
    }

    public void setFtProcess(String ftProcess) {
        this.ftProcess = ftProcess;
    }

    public int getHoldCount() {
        return holdCount;
    }

    public void setHoldCount(int holdCount) {
        this.holdCount = holdCount;
    }

    public Date getTestStartTime() {
        return testStartTime;
    }

    public void setTestStartTime(Date testStartTime) {
        this.testStartTime = testStartTime;
    }

    public Date getTestEndTime() {
        return testEndTime;
    }

    public void setTestEndTime(Date testEndTime) {
        this.testEndTime = testEndTime;
    }

    public int getPassDie() {
        return passDie;
    }

    public void setPassDie(int passDie) {
        this.passDie = passDie;
    }

    public int getFailDie() {
        return failDie;
    }

    public void setFailDie(int failDie) {
        this.failDie = failDie;
    }

    public double getLotYield() {
        return lotYield;
    }

    public void setLotYield(double lotYield) {
        this.lotYield = lotYield;
    }

    public double getStopYield() {
        return stopYield;
    }

    public void setStopYield(double stopYield) {
        this.stopYield = stopYield;
    }

    public String getMajorFail() {
        return majorFail;
    }

    public void setMajorFail(String majorFail) {
        this.majorFail = majorFail;
    }

    public String getProcessYield() {
        return processYield;
    }

    public void setProcessYield(String processYield) {
        this.processYield = processYield;
    }

    public String getFtYield() {
        return ftYield;
    }

    public void setFtYield(String ftYield) {
        this.ftYield = ftYield;
    }

    public String getPassBins() {
        return passBins;
    }

    public void setPassBins(String passBins) {
        this.passBins = passBins;
    }

    public String getOsBins() {
        return osBins;
    }

    public void setOsBins(String osBins) {
        this.osBins = osBins;
    }

    public String getSpecialBins() {
        return specialBins;
    }

    public void setSpecialBins(String specialBins) {
        this.specialBins = specialBins;
    }

    public String getDataBase() {
        return dataBase;
    }

    public void setDataBase(String dataBase) {
        this.dataBase = dataBase;
    }

    public String getTestTime() {
        return testTime;
    }

    public void setTestTime(String testTime) {
        this.testTime = testTime;
    }

    public String getPkg() {
        return pkg;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    public int getGpibBin() {
        return gpibBin;
    }

    public void setGpibBin(int gpibBin) {
        this.gpibBin = gpibBin;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
