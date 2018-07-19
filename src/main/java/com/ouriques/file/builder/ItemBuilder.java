package com.ouriques.file.builder;

import com.ouriques.file.common.BusinessConstant;
import com.ouriques.file.model.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {

    public List<Item> parse(String data) {

        data = data.replaceAll("\\[", "");
        data = data.replaceAll("\\]", "");

        String[] splittedData = data.split(BusinessConstant.ITEM_OBJECT_SEPARATOR);

        List<Item> items = new ArrayList<Item>(splittedData.length);

        for (int i = 0; i < splittedData.length; i++) {

            String[] splittedItem = splittedData[i].split(BusinessConstant.ITEM_SEPARATOR);

            Item newItem = new Item();

            newItem.setId(Integer.parseInt(splittedItem[0]));
            newItem.setQuantity(new Integer(splittedItem[1]));
            newItem.setPrice(new BigDecimal(splittedItem[2]));

            items.add(newItem);
        }

        return items;
    }
}
