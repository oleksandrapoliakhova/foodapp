package com.foodapp.foodapp;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FoodTagColor {

    BLUE("blue", ""),
    RED("red", "");


    private String colorName;
    private String color;

}
