package com.foodapp.foodapp.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum FoodTagColor {

    BLUE("blue", ""),
    RED("red", "");

    private String colorName;
    private String color;

    public static FoodTagColor getFoodTagColor(String colorName) {
        return Arrays.stream(FoodTagColor.values())
                .filter(f -> !f.getColorName().equalsIgnoreCase(colorName)).findFirst().orElse(null);

    }
}
