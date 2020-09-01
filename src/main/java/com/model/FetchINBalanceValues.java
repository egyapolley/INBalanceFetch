package com.model;

import com.sun.xml.internal.ws.client.BindingProviderProperties;
import com.wsdlclasses.CCSCD1;
import com.wsdlclasses.CCSCD1PortType;
import com.wsdlclasses.CCSCD1QRY;
import com.wsdlclasses.CCSCD1QRYResponse;

import javax.xml.bind.JAXBElement;
import javax.xml.ws.BindingProvider;
import java.util.List;
import java.util.Map;

public class FetchINBalanceValues {

    public String getBalance(String msisdn, String balanceType) {

        double finalBalanceValue = 0;

        CCSCD1 ccscd1 = new CCSCD1();

        CCSCD1PortType ccscd1Port = ccscd1.getCCSCD1HttpSoap11Endpoint();
        Map<String, Object> requestContext = ((BindingProvider) ccscd1Port).getRequestContext();
        requestContext.put(BindingProviderProperties.REQUEST_TIMEOUT, 4000);
        requestContext.put(BindingProviderProperties.CONNECT_TIMEOUT, 2000);

        CCSCD1QRY ccscd1QRY = new CCSCD1QRY();
        ccscd1QRY.setMSISDN(msisdn);
        if (balanceType.equals("Bundle ExpiryTrack Status")) ccscd1QRY.setBALANCETYPE("ALL");
        else ccscd1QRY.setBALANCETYPE(balanceType);
        ccscd1QRY.setLISTTYPE("BALANCE");
        ccscd1QRY.setUsername("admin");
        ccscd1QRY.setPassword("admin");

        try {
            if (balanceType.equals("Bundle ExpiryTrack Status")) {
                CCSCD1QRYResponse ccscd1QRYResponse = ccscd1Port.ccscd1QRY(ccscd1QRY);
                List<JAXBElement<?>> authAndMSISDNAndACCOUNTNUMBER = ccscd1QRYResponse.getAUTHAndMSISDNAndACCOUNTNUMBER();
                for (JAXBElement<?> element : authAndMSISDNAndACCOUNTNUMBER) {
                    if (element.getName().getLocalPart().equals("BALANCES")) {
                        JAXBElement<CCSCD1QRYResponse.BALANCES> jaxbElement = (JAXBElement<CCSCD1QRYResponse.BALANCES>) element;
                        CCSCD1QRYResponse.BALANCES balance = jaxbElement.getValue();
                        List<CCSCD1QRYResponse.BALANCES.BALANCEITEM> balanceitem = balance.getBALANCEITEM();
                        for (CCSCD1QRYResponse.BALANCES.BALANCEITEM balanceitem1 : balanceitem) {
                            if (balanceitem1.getBALANCETYPENAME().endsWith("Surfplus Data")) {

                                CCSCD1QRYResponse.BALANCES.BALANCEITEM.BUCKETS buckets = balanceitem1.getBUCKETS();
                                List<CCSCD1QRYResponse.BALANCES.BALANCEITEM.BUCKETS.BUCKETITEM> bucketitems = buckets.getBUCKETITEM();
                                if (bucketitems != null) {
                                    for (CCSCD1QRYResponse.BALANCES.BALANCEITEM.BUCKETS.BUCKETITEM bucketitem : bucketitems) {

                                        String bucketValue = bucketitem.getBUCKETVALUE();
                                        if (bucketValue != null) finalBalanceValue += Integer.parseInt(bucketValue);

                                    }


                                }


                            }

                        }

                    }


                }


            }else {
                CCSCD1QRYResponse ccscd1QRYResponse = ccscd1Port.ccscd1QRY(ccscd1QRY);
                List<JAXBElement<?>> authAndMSISDNAndACCOUNTNUMBER = ccscd1QRYResponse.getAUTHAndMSISDNAndACCOUNTNUMBER();
                for (JAXBElement<?> element:authAndMSISDNAndACCOUNTNUMBER) {
                    if (element.getName().getLocalPart().equals("BALANCE")){
                        finalBalanceValue +=Integer.parseInt(element.getValue().toString());
                    }


                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;


        }

        return String.format("%.2f",(finalBalanceValue/1048576.0));
    }
}
