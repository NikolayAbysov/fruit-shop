package com.dev.fruitshop.controller;

import com.dev.fruitshop.model.Fruit;
import com.dev.fruitshop.service.FruitService;
import com.dev.fruitshop.service.impl.FruitServiceImpl;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CreateFruitFileController {
    private static final FruitService fruitService = new FruitServiceImpl();

    public static void createFile(String filePath) {
        List<Fruit> fruits = fruitService.getFruitStock();
        JSONArray fruitList = new JSONArray();
        for (Fruit fruit : fruits) {
            JSONObject fruitDetails = new JSONObject();
            fruitDetails.put("type", fruit.getFruitType().getFruitName());
            fruitDetails.put("shelfLife", fruit.getShelfLife());
            fruitDetails.put("date", (fruit.getDeliverDate().toString()));
            fruitDetails.put("price", fruit.getPrice());

            JSONObject fruitObject = new JSONObject();
            fruitObject.put("fruits", fruitDetails);
            fruitList.add(fruitObject);
        }
        try (FileWriter file = new FileWriter(filePath)) {

            file.write(fruitList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
