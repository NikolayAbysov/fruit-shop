package com.dev.fruitshop.controller;

import com.dev.fruitshop.model.FruitType;
import com.dev.fruitshop.model.Order;
import java.util.ArrayList;
import java.util.List;

public class InitOrderController {
    public static List<Order> init() {
        Order order = new Order();
        order.setAmount(1);
        order.setCustomerName("Shion");
        order.setFruitType(FruitType.of("Apple"));
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        return orders;
    }
}
