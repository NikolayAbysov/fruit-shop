package com.dev.fruitshop.controller;

import com.dev.fruitshop.model.Fruit;
import com.dev.fruitshop.model.FruitType;
import com.dev.fruitshop.service.FruitService;
import com.dev.fruitshop.service.impl.FruitServiceImpl;
import java.time.LocalDate;

public class InitFruitController {
    private static final FruitService fruitService = new FruitServiceImpl();

    public static void init() {
        Fruit appleFruit = new Fruit();
        appleFruit.setFruitType(FruitType.of("Apple"));
        appleFruit.setDeliverDate(LocalDate.now().minusDays(1));
        appleFruit.setPrice(100);
        appleFruit.setShelfLife(10);

        Fruit appleFruit2 = new Fruit();
        appleFruit2.setFruitType(FruitType.of("Apple"));
        appleFruit2.setDeliverDate(LocalDate.now().minusDays(1));
        appleFruit2.setPrice(100);
        appleFruit2.setShelfLife(10);

        Fruit bananaFruit = new Fruit();
        bananaFruit.setFruitType(FruitType.of("Banana"));
        bananaFruit.setDeliverDate(LocalDate.now().minusDays(1));
        bananaFruit.setPrice(250);
        bananaFruit.setShelfLife(5);

        fruitService.add(appleFruit);
        fruitService.add(appleFruit2);
        fruitService.add(bananaFruit);
    }
}
