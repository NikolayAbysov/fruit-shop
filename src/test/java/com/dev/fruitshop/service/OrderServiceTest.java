package com.dev.fruitshop.service;

import com.dev.fruitshop.controller.LoadFruitFileController;
import com.dev.fruitshop.model.Fruit;
import com.dev.fruitshop.model.FruitType;
import com.dev.fruitshop.model.Order;
import com.dev.fruitshop.service.impl.FruitServiceImpl;
import com.dev.fruitshop.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class OrderServiceTest {
    private static Fruit fruit;
    private static FruitService fruitService;
    private static Order order;
    private static OrderService orderService;

    @BeforeEach
    void init() {
        fruitService = new FruitServiceImpl();
        fruitService.addList(LoadFruitFileController.readFile());
        order = new Order();
        order.setAmount(1);
        order.setCustomerName("Shion");
        order.setFruitType(FruitType.of("Apple"));
        orderService = new OrderServiceImpl();
    }

    @Test
    void completeOrderOk() {
        orderService.completeOrder(order);
        Assertions.assertEquals(1, fruitService.getAvailableFruits(LocalDate.now(),
                FruitType.of("Apple")).size());
    }

}