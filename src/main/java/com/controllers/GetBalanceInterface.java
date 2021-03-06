package com.controllers;

import com.model.RequestDetails;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;


@WebService
public interface GetBalanceInterface {

    @WebMethod
    @WebResult(name = "balanceValue")
    String getBalanceValue(@WebParam(name = "balanceDetails") RequestDetails requestDetails);
}
