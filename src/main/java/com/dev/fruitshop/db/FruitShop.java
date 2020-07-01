package com.dev.fruitshop.db;

import com.dev.fruitshop.exception.NoFruitException;
import com.dev.fruitshop.model.Fruit;
import java.util.ArrayList;
import java.util.List;

public class FruitShop {
    private static final List<Fruit> stock = new ArrayList<>();
    private static int MONEY_BALANCE = 0;

    public static Fruit addFruit(Fruit fruit) {
        stock.add(fruit);
        return fruit;
    }

    public static Fruit removeFruit(Fruit fruit) {
        if (!stock.contains(fruit)) {
            throw new NoFruitException("No Such Fruit in stock");
        }
        stock.remove(fruit);
        return fruit;
    }

    public static List<Fruit> getFruitStock() {
        return stock;
    }

    public static int changeMoneyBalance(int value) {
        MONEY_BALANCE = MONEY_BALANCE + value;
        return MONEY_BALANCE;
    }

    public static int getMoneyBalance() {
        return MONEY_BALANCE;
    }
}
