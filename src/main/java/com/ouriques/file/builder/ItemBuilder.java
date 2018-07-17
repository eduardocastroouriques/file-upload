package com.ouriques.file.builder;

import com.ouriques.file.common.BusinessConstant;
import com.ouriques.file.model.Item;

import java.math.BigDecimal;

public class ItemBuilder {

    public Item[] parse(String data) {

        data = data.replaceAll("\\[", "");
        data = data.replaceAll("\\]", "");

        String[] splittedData = data.split(BusinessConstant.ITEM_OBJECT_SEPARATOR);

        Item[] items = new Item[splittedData.length];

        for (int i = 0; i < splittedData.length; i++) {

            String[] splittedItem = splittedData[i].split(BusinessConstant.ITEM_SEPARATOR);

            Item newItem = new Item();

            newItem.setId(splittedItem[0]);
            newItem.setQuantity(new Integer(splittedItem[1]));
            newItem.setPrice(new BigDecimal(splittedItem[2]));

            items[i] = newItem;
        }

        return items;
    }
}
