package com.ouriques.file.builder;

import com.ouriques.file.common.BusinessConstant;
import com.ouriques.file.model.Sale;

public class SaleBuilder {

    public Sale parse(String data) {

        String[] splittedData = data.split(BusinessConstant.SALE_SEPARATOR);

        Sale sale = new Sale();

        sale.setSaleId(splittedData[1]);
        sale.setItem(new ItemBuilder().parse(splittedData[2]));
        sale.setSalesManName(splittedData[3]);

        return sale;
    }
}
