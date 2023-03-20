package com.foodapp.foodapp.controllers;

import com.foodapp.foodapp.services.FoodEntryService;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.foodapp.foodapp.ApiConstants.*;

@RequestMapping("/food-entry")
@RestController
public class FoodEntryController {

    private final FoodEntryService foodEntryService;

    public FoodEntryController(FoodEntryService foodEntryService) {
        this.foodEntryService = foodEntryService;
    }

    @PostMapping(value = SAVE_FOOD_ENTRY)
    public void saveFoodEntry(@PathVariable String food, @PathVariable String date,
                              @RequestParam(required = false) List<String> foodTagIdList) {
        Assert.notNull(food, "food should not be null");
        Assert.notNull(date, "date should not be null");

        foodEntryService.saveFoodEntry(food, foodTagIdList, date);
    }

    @DeleteMapping(value = DELETE_FOOD_ENTRY)
    public void deleteFoodEntry(@PathVariable Integer foodEntryId, String dayEntryId) {
        Assert.notNull(foodEntryId, "foodEntryId should not be null");
        Assert.notNull(dayEntryId, "dayEntryId should not be null");

        foodEntryService.deleteFoodEntry(foodEntryId, dayEntryId);
    }

    @PostMapping(value = UPDATE_FOOD_ENTRY)
    public void updateFoodEntry(@PathVariable Integer foodEntryId, @PathVariable String food, @PathVariable String dayEntryId,
                                @RequestParam(required = false) List<String> foodTagIdList) {
        Assert.notNull(foodEntryId, "foodEntryId should not be null");
        Assert.notNull(food, "food should not be null");
        Assert.notNull(dayEntryId, "dayEntryId should not be null");

        foodEntryService.updateFoodEntry(foodEntryId, dayEntryId, food, foodTagIdList);
    }
}
