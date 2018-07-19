package com.ouriques.file.service.sale;

import com.ouriques.file.builder.SaleBuilder;
import com.ouriques.file.model.Sale;
import com.ouriques.file.repository.SaleRepository;
import com.ouriques.file.service.IProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService implements IProcessing {

    @Autowired
    private SaleRepository repository;

    @Override
    public void process(String data) throws Exception {

        Sale sale = new SaleBuilder().parse(data);

        repository.save(sale);
    }
}
