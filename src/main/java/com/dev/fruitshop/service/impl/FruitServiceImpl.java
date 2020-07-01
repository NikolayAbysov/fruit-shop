package com.dev.fruitshop.service.impl;

import com.dev.fruitshop.dao.FruitDao;
import com.dev.fruitshop.dao.impl.FruitDaoImpl;
import com.dev.fruitshop.model.Fruit;
import com.dev.fruitshop.model.FruitType;
import com.dev.fruitshop.service.FruitService;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {

    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public Fruit add(Fruit fruit) {
        return fruitDao.add(fruit);
    }

    @Override
    public Fruit remove(Fruit fruit) {
        return fruitDao.remove(fruit);
    }

    @Override
    public void addList(List<Fruit> fruits) {
        fruits.forEach(this::add);
    }

    @Override
    public List<Fruit> getFruitStock() {
        return fruitDao.getFruitStock();
    }

    @Override
    public List<Fruit> getSpoiledFruits(LocalDate expiresToDate) {
        List<Fruit> fruits = fruitDao.getFruitStock();
        return fruits.stream()
                .filter(f -> f
                        .getDeliverDate()
                        .plusDays(f.getShelfLife())
                        .isBefore(expiresToDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<Fruit> getSpoiledFruits(LocalDate expiresToDate, FruitType fruitType) {
        List<Fruit> fruits = fruitDao.getFruitStock();
        return fruits.stream()
                .filter(f -> f
                        .getDeliverDate()
                        .plusDays(f.getShelfLife())
                        .isBefore(expiresToDate))
                .filter(f -> f
                        .getFruitType()
                        .getFruitName()
                        .equals(fruitType.getFruitName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Fruit> getAvailableFruits(LocalDate date) {
        List<Fruit> fruits = fruitDao.getFruitStock();
        return fruits.stream()
                .filter(f -> f.getDeliverDate().isBefore(date))
                .filter(f -> f
                        .getDeliverDate()
                        .plusDays(f.getShelfLife())
                        .isAfter(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<Fruit> getAvailableFruits(LocalDate date, FruitType fruitType) {
        List<Fruit> fruits = fruitDao.getFruitStock();
        return fruits.stream()
                .filter(f -> f
                        .getDeliverDate()
                        .isBefore(date))
                .filter(f -> f
                        .getFruitType()
                        .getFruitName()
                        .equals(fruitType.getFruitName()))
                .filter(f -> f
                        .getDeliverDate()
                        .plusDays(f.getShelfLife())
                        .isAfter(date))
                .collect(Collectors.toList());
    }
}
