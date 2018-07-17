package com.ouriques.file.service;

import com.ouriques.file.builder.CustomerBuilder;
import com.ouriques.file.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements IFileService{


    @Override
    public void process(String data) throws Exception {

        Customer customer = new CustomerBuilder().parse(data);
        String t = "";
    }
}
