package com.dev.fruitshop.service;

import com.dev.fruitshop.model.Fruit;
import com.dev.fruitshop.model.FruitType;
import java.time.LocalDate;
import java.util.List;

public interface FruitService {

    Fruit add(Fruit fruit);

    Fruit remove(Fruit fruit);

    void addList(List<Fruit> fruits);

    List<Fruit> getFruitStock();

    List<Fruit> getSpoiledFruits(LocalDate date);

    List<Fruit> getSpoiledFruits(LocalDate date, FruitType fruitType);

    List<Fruit> getAvailableFruits(LocalDate date);

    List<Fruit> getAvailableFruits(LocalDate date, FruitType fruitType);
}
