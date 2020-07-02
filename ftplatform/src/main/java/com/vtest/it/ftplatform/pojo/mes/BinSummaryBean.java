package com.vtest.it.ftplatform.pojo.mes;

import lombok.Data;

import java.io.Serializable;

@Data
public class BinSummaryBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String waferLot;
    private String waferId;
    private String cpStep;
    private String startTestTime;
    private String endTestTime;
    private String binCode;
    private String binQty;
}
