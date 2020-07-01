package com.dev.fruitshop.dao;

import com.dev.fruitshop.model.Fruit;
import java.util.List;

public interface FruitDao {

    Fruit add(Fruit fruit);

    Fruit remove(Fruit fruit);

    List<Fruit> getFruitStock();
}
