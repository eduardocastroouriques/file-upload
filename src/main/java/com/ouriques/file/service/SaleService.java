package com.ouriques.file.service;

import com.ouriques.file.builder.SaleBuilder;
import com.ouriques.file.model.Sale;
import org.springframework.stereotype.Service;

@Service
public class SaleService implements IFileService{


    @Override
    public void process(String data) throws Exception {

        Sale sale = new SaleBuilder().parse(data);
        String t = "";
    }
}
