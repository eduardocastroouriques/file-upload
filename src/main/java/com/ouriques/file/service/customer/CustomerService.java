package com.ouriques.file.service.customer;

import com.ouriques.file.builder.CustomerBuilder;
import com.ouriques.file.model.Customer;
import com.ouriques.file.repository.CustomerRepository;
import com.ouriques.file.service.IProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements IProcessing {

    @Autowired
    private CustomerRepository repository;

    @Override
    public void process(String data) throws Exception {

        Customer customer = new CustomerBuilder().parse(data);

        repository.save(customer);
    }
}
