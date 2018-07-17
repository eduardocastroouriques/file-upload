package com.ouriques.file.builder;

import com.ouriques.file.common.BusinessConstant;
import com.ouriques.file.model.Customer;

public class CustomerBuilder {

    public Customer parse(String data) {

        String[] splittedData = data.split(BusinessConstant.CUSTOMER_SEPARATOR);

        Customer customer = new Customer();

        customer.setCnpj(splittedData[1]);
        customer.setName(splittedData[2]);
        customer.setBusinessArea(splittedData[3]);

        return customer;
    }
}
