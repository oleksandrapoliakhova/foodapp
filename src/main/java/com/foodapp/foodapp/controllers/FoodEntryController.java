package com.foodapp.foodapp.controllers;

import com.foodapp.foodapp.dto.FoodTagDTO;
import com.foodapp.foodapp.entity.FoodTag;
import com.foodapp.foodapp.services.FoodEntryService;
import org.bson.types.ObjectId;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.foodapp.foodapp.ApiConstants.SAVE_FOOD_ENTRY;

@RestController
public class FoodEntryController {

    private final FoodEntryService foodEntryService;

    public FoodEntryController(FoodEntryService foodEntryService) {
        this.foodEntryService = foodEntryService;
    }

    @PostMapping(value = SAVE_FOOD_ENTRY)
    public void saveFoodEntry(String food, List<FoodTagDTO> foodTagList) {
        Assert.notNull(food , "Food should not be null");
        foodEntryService.saveFoodEntry(food, foodTagList);
    }

//    @RequestMapping(value = SAVE_FOOD_ENTRY, method = RequestMethod.POST)
//    public void deleteFoodEntry(ObjectId foodEntryId) {
//        Assert.notNull(foodEntryId , "foodEntryId should not be null");
//        foodEntryService.saveFoodEntry(food, foodTagList);
//    }
}
