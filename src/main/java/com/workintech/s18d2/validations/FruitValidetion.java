package com.workintech.s18d2.validations;

import com.workintech.s18d2.entity.FruitType;
import com.workintech.s18d2.exceptions.PlantException;
import org.springframework.http.HttpStatus;

public class FruitValidetion {

    public static void checkId(Long id) {
        if (id < 0) {
            throw new PlantException("ID must be bigger than 0", HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkName(String name) {
        if (name == null || name.isEmpty()) {
            throw new PlantException("name is null or empty!", HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkPrice(Double price) {
        if (price == null) {
            throw new PlantException("price is null or empty!", HttpStatus.BAD_REQUEST);
        } else if (price < 0) {
            throw new PlantException("price must be bigger than zero!", HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkFruitType(FruitType fruitType) {
        if (fruitType == null) {
            throw new PlantException("fruit type is null or empty!", HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkAll(Long id, String name, Double price, FruitType fruitType) {
        checkId(id);
        checkName(name);
        checkPrice(price);
        checkFruitType(fruitType);
    }

}
