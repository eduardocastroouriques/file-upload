package com.ouriques.file.builder;

import com.ouriques.file.common.BusinessConstant;
import com.ouriques.file.model.SaleMan;

import java.math.BigDecimal;

public class SaleManBuilder {

    public SaleMan parse(String data) {

        String[] splittedData = data.split(BusinessConstant.SALES_MAN_SEPARATOR);

        SaleMan saleMan = new SaleMan();

        saleMan.setType(splittedData[0]);
        saleMan.setCpf(splittedData[1]);
        saleMan.setName(splittedData[2]);
        saleMan.setSalary(new BigDecimal(splittedData[3]));

        return saleMan;
    }
}
