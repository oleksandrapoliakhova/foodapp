package com.foodapp.foodapp.controllers;

import com.foodapp.foodapp.FoodTagColor;
import com.foodapp.foodapp.dto.FoodTagDTO;
import com.foodapp.foodapp.entity.FoodTag;
import com.foodapp.foodapp.services.FoodTagService;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.foodapp.foodapp.ApiConstants.*;

@RequestMapping("/food-tag")
@RestController
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

    @GetMapping(value = GET_FOOD_TAGS)
    public List<FoodTagDTO> getFoodTags(@PathVariable String foodEntryId) {
        Assert.notNull(foodEntryId , "Food entry id should not be null");
        return foodTagService.getFoodTags(foodEntryId);
    }

    @DeleteMapping(value = DELETE_FOOD_TAG)
    public void deleteFoodTag(@PathVariable String foodTagId) {
        Assert.notNull(foodTagId , "Food tag id should not be null");
        foodTagService.deleteFoodTag(foodTagId);
    }
}
