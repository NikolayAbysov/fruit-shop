package com.dev.fruitshop.service;

import com.dev.fruitshop.db.FruitShop;
import com.dev.fruitshop.exception.NotEnoughFruitsInStock;
import com.dev.fruitshop.model.Fruit;
import com.dev.fruitshop.model.FruitType;
import com.dev.fruitshop.service.impl.FruitServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

class FruitServiceTest {
    private static Fruit fruit;
    private static FruitService fruitService;

    @BeforeEach
    void init() {
        fruit = new Fruit();
        fruit.setFruitType(FruitType.of("Apple"));
        fruit.setDeliverDate(LocalDate.now());
        fruit.setPrice(100);
        fruit.setShelfLife(5);
        fruitService = new FruitServiceImpl();
    }

    @Test
    void addFruitServiceOk() {
        fruitService.add(fruit);
        Assertions.assertTrue(FruitShop.getFruitStock().contains(fruit));
    }

    @Test
    void removeFruitServiceOk() {
        fruitService.add(fruit);
        fruitService.remove(fruit);
        Assertions.assertFalse(FruitShop.getFruitStock().contains(fruit));
    }

    @Test
    void addListFruitServiceOk() {
        List<Fruit> fruits = List.of(fruit);
        fruitService.addList(fruits);
        Assertions.assertTrue(FruitShop.getFruitStock().size() > 0);
    }

    @Test
    void  getSpoiledFruitsOk() {
        fruitService.add(fruit);
        Assertions.assertEquals(1, fruitService.getSpoiledFruits(LocalDate.now().plusDays(6)).size());
    }

    @Test
    void  getSpoiledFruitsTypeOk() {
        fruitService.add(fruit);
        Assertions.assertEquals(1, fruitService.getSpoiledFruits(LocalDate.now().plusDays(6),
                fruit.getFruitType()).size());
    }

    @Test
    void  getAvailableFruits() {
        fruitService.add(fruit);
        Assertions.assertEquals(1, fruitService.getAvailableFruits(LocalDate.now().plusDays(1)).size());
    }
}
