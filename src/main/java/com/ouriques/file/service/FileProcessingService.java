package com.ouriques.file.service;

import com.ouriques.file.common.BusinessConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class FileProcessingService {

    private static final Logger logger = LoggerFactory.getLogger(FileProcessingService.class);

    private final String in = "./uploads/";

    @Autowired
    public SalesManService salesManService;

    @Autowired
    public CustomerService customerService;

    @Autowired
    public SaleService saleService;

    @Autowired
    public FileProcessingService() {

    }

    public void processFile(String fileName){

        try (Stream<String> stream = Files.lines(Paths.get(this.in + fileName))) {
            stream.forEach(fileRow -> goToTheRightService(fileRow));
        } catch (IOException e) {
            e.printStackTrace();
        }


        String t = "";

    }

    private void goToTheRightService(String data) {

        try {

            if(data.contains(BusinessConstant.SALES_MAN_ID)){
                salesManService.process(data);
            }else if(data.contains(BusinessConstant.CUSTOMER_ID)){
                customerService.process(data);
            }else if(data.contains(BusinessConstant.SALE_ID)){
                saleService.process(data);
            }else{
                logger.error("ERRO AO PROCESSAR A LINHA: " + data);
            }

        }catch (Exception e){
            logger.error(e.getMessage());
        }


    }
}
