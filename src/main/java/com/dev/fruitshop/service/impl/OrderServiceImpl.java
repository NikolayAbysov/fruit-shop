package com.dev.fruitshop.service.impl;

import com.dev.fruitshop.dao.OrderDao;
import com.dev.fruitshop.dao.impl.OrderDaoImpl;
import com.dev.fruitshop.exception.NotEnoughFruitsInStock;
import com.dev.fruitshop.model.Fruit;
import com.dev.fruitshop.model.Order;
import com.dev.fruitshop.service.FruitService;
import com.dev.fruitshop.service.OrderService;
import java.time.LocalDate;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private static FruitService fruitService = new FruitServiceImpl();
    private static OrderDao orderDao = new OrderDaoImpl();

    @Override
    public Order completeOrder(Order order) {
        List<Fruit> fruits = fruitService.getAvailableFruits(LocalDate.now(), order.getFruitType());

        if (fruits.size() < order.getAmount()) {
            throw new NotEnoughFruitsInStock("Not enough fruit in stock");
        }
        for (int i = 0; i < order.getAmount(); i++) {
            orderDao.changeMoneyBalance(fruits.get(0).getPrice());
            fruitService.remove(fruits.get(i));
        }
        return order;
    }

    @Override
    public void completeOrderList(List<Order> orders) {
        for (Order order : orders) {
            completeOrder(order);
        }
    }
}
