package com.foodapp.foodapp.controllers;

import com.foodapp.foodapp.dto.CreationFoodTagDTO;
import com.foodapp.foodapp.dto.FoodTagDTO;
import com.foodapp.foodapp.entity.FoodEntry;
import com.foodapp.foodapp.services.FoodTagService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/food-tag")
@CrossOrigin(origins = {"http://localhost:4200/", "https://foodapp-poliakhova-ui.herokuapp.com/"})
public class FoodTagController {

    private final FoodTagService foodTagService;

    public FoodTagController(FoodTagService foodTagService) {
        this.foodTagService = foodTagService;
    }

    @PostMapping(value = "/save-food-tag", produces = MediaType.APPLICATION_JSON_VALUE)
    public FoodTagDTO saveFoodTag(@RequestBody CreationFoodTagDTO creationFoodTagDTO) {
        Assert.notNull(creationFoodTagDTO.getFoodTagName(), "Food tag name should not be null");
        Assert.notNull(creationFoodTagDTO.getFoodTagColor(), "Food tag color name should not be null");

        return foodTagService.saveFoodTag(creationFoodTagDTO.getFoodTagName(),
                creationFoodTagDTO.getFoodTagColor());
    }

    @PostMapping(value = "/append-food-tag/{foodEntryId}/food-tags/{foodTagIds}")
    public FoodEntry appendFoodTagIdToEntry(@PathVariable List<String> foodTagIds,
                                            @PathVariable Integer foodEntryId) {
        Assert.notNull(foodEntryId, "foodEntryId should not be null");
        Assert.isTrue(CollectionUtils.isNotEmpty(foodTagIds), "foodEntryId should not be null");

        return foodTagService.appendFoodTagToEntry(foodTagIds, foodEntryId);
    }

    @DeleteMapping(value = "/delete-food-tag/{foodEntryId}/food-tags",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public FoodEntry deleteFoodTagIdFromEntry(@PathVariable String foodEntryId) {
        Assert.notNull(foodEntryId, "foodEntryId should not be null");

        return foodTagService.deleteFoodTagsFromEntry(foodEntryId);
    }

    @GetMapping(value = "/get-all-food-tags")
    public List<FoodTagDTO> getFoodTags() {
        return foodTagService.getAllFoodTags();
    }

    @DeleteMapping(value = "/delete-food-tag/{foodTagId}")
    public void deleteFoodTag(@PathVariable Integer foodTagId) {
        Assert.notNull(foodTagId, "Food tag id should not be null");

        foodTagService.deleteFoodTag(foodTagId);
    }
}
