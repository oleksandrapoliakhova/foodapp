package com.foodapp.foodapp.controllers;

import com.foodapp.foodapp.types.FoodTagColor;
import com.foodapp.foodapp.dto.FoodTagDTO;
import com.foodapp.foodapp.services.FoodTagService;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.foodapp.foodapp.ApiConstants.*;

@RestController
@RequestMapping("/food-tag")
public class FoodTagController {

    private final FoodTagService foodTagService;

    public FoodTagController(FoodTagService foodTagService) {
        this.foodTagService = foodTagService;
    }

    @PostMapping(value = SAVE_FOOD_TAG)
    public void saveFoodTag(@PathVariable String foodTagName, @PathVariable FoodTagColor foodTagColor) {
        Assert.notNull(foodTagName , "Food tag name should not be null");
        Assert.notNull(foodTagColor, "Food tag color name should not be null");
        foodTagService.saveFoodTag(foodTagName, foodTagColor);
    }

    @GetMapping(value = GET_ALL_FOOD_TAGS)
    public List<FoodTagDTO> getFoodTags() {
        return foodTagService.getAllFoodTags();
    }

    @DeleteMapping(value = DELETE_FOOD_TAG)
    public void deleteFoodTag(@PathVariable String foodTagId) {
        Assert.notNull(foodTagId , "Food tag id should not be null");
        foodTagService.deleteFoodTag(foodTagId);
    }
}
