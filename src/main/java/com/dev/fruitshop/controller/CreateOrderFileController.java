package com.dev.fruitshop.controller;

import com.dev.fruitshop.model.Order;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CreateOrderFileController {

    public static void createFile(String filePath) {
        List<Order> orders = InitOrderController.init();
        JSONArray orderList = new JSONArray();
        for (Order order : orders) {
            JSONObject orderDetails = new JSONObject();
            orderDetails.put("customerName", order.getCustomerName());
            orderDetails.put("fruitType", order.getFruitType().getFruitName());
            orderDetails.put("amount", order.getAmount());

            JSONObject orderObject = new JSONObject();
            orderObject.put("order", orderDetails);
            orderList.add(orderObject);
        }
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(orderList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
