package com.dev.fruitshop.dao.impl;

import com.dev.fruitshop.dao.FruitDao;
import com.dev.fruitshop.db.FruitShop;
import com.dev.fruitshop.model.Fruit;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Fruit add(Fruit fruit) {
        return FruitShop.addFruit(fruit);
    }

    @Override
    public Fruit remove(Fruit fruit) {
        return FruitShop.removeFruit(fruit);
    }

    @Override
    public List<Fruit> getFruitStock() {
        return FruitShop.getFruitStock();
    }

}
