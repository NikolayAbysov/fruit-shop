package com.dev.fruitshop.model;

public class FruitType {
    private String fruitName;

    public FruitType(String fruitName) {
        this.fruitName = fruitName;
    }

    public static FruitType of(String fruitTypeName) {
        return new FruitType(fruitTypeName);
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }
}
