package com.dev.fruitshop.dao.impl;

import com.dev.fruitshop.dao.OrderDao;
import com.dev.fruitshop.db.FruitShop;

public class OrderDaoImpl implements OrderDao {

    @Override
    public int changeMoneyBalance(int value) {
        return FruitShop.changeMoneyBalance(value);
    }
}
