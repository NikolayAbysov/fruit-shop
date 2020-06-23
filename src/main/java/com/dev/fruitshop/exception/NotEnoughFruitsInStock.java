package com.dev.fruitshop.exception;

public class NotEnoughFruitsInStock extends RuntimeException {
    public NotEnoughFruitsInStock(String message) {
        super(message);
    }
}
