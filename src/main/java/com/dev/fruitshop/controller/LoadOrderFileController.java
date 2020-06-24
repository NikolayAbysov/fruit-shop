package com.dev.fruitshop.controller;

import com.dev.fruitshop.model.FruitType;
import com.dev.fruitshop.model.Order;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LoadOrderFileController {

    public static List<Order> readFile(String filePath) {
        JSONParser jsonParser = new JSONParser();
        List<Order> orders = new ArrayList<>();

        try (FileReader reader = new FileReader(filePath)) {
            Object obj = jsonParser.parse(reader);
            JSONArray orderList = (JSONArray) obj;
            orderList.forEach(f -> orders.add(parseOrderObject((JSONObject)f)));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return orders;
    }

    private static Order parseOrderObject(JSONObject order) {
        JSONObject orderObject = (JSONObject) order.get("order");
        FruitType fruitType = FruitType.of((String) orderObject.get("fruitType"));
        int amount = ((Long) orderObject.get("amount")).intValue();
        String customerName = (String) orderObject.get("customerName");
        Order parsedOrder = new Order();
        parsedOrder.setFruitType(fruitType);
        parsedOrder.setCustomerName(customerName);
        parsedOrder.setAmount(amount);
        return parsedOrder;
    }
}
