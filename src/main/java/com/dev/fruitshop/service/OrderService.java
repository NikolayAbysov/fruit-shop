package com.dev.fruitshop.service;

import com.dev.fruitshop.model.Order;
import java.util.List;

public interface OrderService {

    Order completeOrder(Order order);

    void completeOrderList(List<Order> orders);
}
