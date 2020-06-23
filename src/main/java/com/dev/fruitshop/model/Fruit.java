package com.dev.fruitshop.model;

import java.time.LocalDate;

public class Fruit {
    private FruitType fruitType;
    private int shelfLife;
    private LocalDate deliverDate;
    private int price;

    public FruitType getFruitType() {
        return fruitType;
    }

    public void setFruitType(FruitType fruitType) {
        this.fruitType = fruitType;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife;
    }

    public LocalDate getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(LocalDate deliverDate) {
        this.deliverDate = deliverDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
