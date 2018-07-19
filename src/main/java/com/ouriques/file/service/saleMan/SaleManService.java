package com.ouriques.file.service.saleMan;

import com.ouriques.file.builder.SaleManBuilder;
import com.ouriques.file.model.SaleMan;
import com.ouriques.file.repository.SaleManRepository;
import com.ouriques.file.service.IProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleManService implements IProcessing {

    @Autowired
    private SaleManRepository repository;

    @Override
    public void process(String data) throws Exception {

        SaleMan saleMan = new SaleManBuilder().parse(data);

        repository.save(saleMan);

    }
}
