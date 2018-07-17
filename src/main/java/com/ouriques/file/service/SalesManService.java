package com.ouriques.file.service;

import com.ouriques.file.builder.SaleManBuilder;
import com.ouriques.file.model.SaleMan;
import org.springframework.stereotype.Service;

@Service
public class SalesManService implements IFileService{


    @Override
    public void process(String data) throws Exception {

        SaleMan saleMan = new SaleManBuilder().parse(data);
        String t = "";

    }
}
