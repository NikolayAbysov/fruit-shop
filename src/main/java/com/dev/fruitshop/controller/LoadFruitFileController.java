package com.dev.fruitshop.controller;

import com.dev.fruitshop.model.Fruit;
import com.dev.fruitshop.model.FruitType;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LoadFruitFileController {
    private static final String FILE_PATH = "src/jsonSource/fruits.json";

    public static List<Fruit> readFile() {
        JSONParser jsonParser = new JSONParser();
        List<Fruit> fruits = new ArrayList<>();

        try (FileReader reader = new FileReader(FILE_PATH)) {
            Object obj = jsonParser.parse(reader);
            JSONArray fruitList = (JSONArray) obj;
            fruitList.forEach(f -> fruits.add(parseFruitObject((JSONObject)f)));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return fruits;
    }

    private static Fruit parseFruitObject(JSONObject fruit) {
        JSONObject fruitObject = (JSONObject) fruit.get("fruits");
        FruitType fruitType = FruitType.of((String) fruitObject.get("type"));
        int shelfLife = ((Long) fruitObject.get("shelfLife")).intValue();
        LocalDate deliverDate = LocalDate.parse((String) fruitObject.get("date"));
        int price = ((Long) fruitObject.get("price")).intValue();
        Fruit parsedFruit = new Fruit();
        parsedFruit.setFruitType(fruitType);
        parsedFruit.setShelfLife(shelfLife);
        parsedFruit.setPrice(price);
        parsedFruit.setDeliverDate(deliverDate);
        return parsedFruit;
    }
}
