package com.vtest.it.fttesterdataloginitialtext.pojo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author shawn.sun
 * @date 2020/08/26  14:30
 */
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class DataLogPathBean {
    private String customerCode;
    private String device;
    private String lot;
    private String vLot;
    private String ftStep;
}
