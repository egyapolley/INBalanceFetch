package com.controllers;

import com.model.FetchINBalanceValues;
import com.model.RequestDetails;

import javax.jws.WebService;

@WebService(endpointInterface = "com.controllers.GetBalanceInterface")
public class GetBalanceMain implements GetBalanceInterface{
    @Override
    public String getBalanceValue(RequestDetails requestDetails) {
        if (requestDetails != null){
            String msisdn = requestDetails.getMsisdn();
            String balanceType = requestDetails.getBalanceType();
            if (!msisdn.isEmpty()) {
                if (balanceType.endsWith("Surfplus Data") || balanceType.equals("Bundle ExpiryTrack Status")) {
                    return new FetchINBalanceValues().getBalance(msisdn,balanceType);
                }
            }
        }

        return  null;

    }
}
