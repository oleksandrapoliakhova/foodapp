package com.foodapp.foodapp.controllers;

import com.foodapp.foodapp.dto.FoodTagDTO;
import com.foodapp.foodapp.services.FoodEntryService;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public void saveFoodEntry(@PathVariable String food, @PathVariable LocalDate date,
                              @RequestParam(required = false) List<FoodTagDTO> foodTagList) {
        Assert.notNull(food, "food should not be null");
        Assert.notNull(date, "date should not be null");
        foodEntryService.saveFoodEntry(food, foodTagList, date);
    }

    @DeleteMapping(value = DELETE_FOOD_ENTRY)
    public void deleteFoodEntry(@PathVariable String foodEntryId) {
        Assert.notNull(foodEntryId, "foodEntryId should not be null");
        foodEntryService.deleteFoodEntry(foodEntryId);
    }

    @PostMapping(value = UPDATE_FOOD_ENTRY)
    public void updateFoodEntry(@PathVariable String foodEntryId, @PathVariable String food,
                                @RequestParam(required = false) List<FoodTagDTO> foodTagList) {
        Assert.notNull(foodEntryId, "foodEntryId should not be null");
        Assert.notNull(food, "food should not be null");

        foodEntryService.deleteFoodEntry(foodEntryId);
    }
}
