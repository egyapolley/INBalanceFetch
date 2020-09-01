package com.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "balanceDetails")
public class RequestDetails {

    private String msisdn;
    private String balanceType;

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(String balanceType) {
        this.balanceType = balanceType;
    }

    @Override
    public String toString() {
        return "RequestDetails{" +
                "msisdn='" + msisdn + '\'' +
                ", balanceType='" + balanceType + '\'' +
                '}';
    }
}
