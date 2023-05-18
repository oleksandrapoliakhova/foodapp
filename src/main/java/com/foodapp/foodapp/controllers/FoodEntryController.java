package com.foodapp.foodapp.controllers;

import com.foodapp.foodapp.dto.CreationFoodEntryDTO;
import com.foodapp.foodapp.dto.FoodEntryDTO;
import com.foodapp.foodapp.services.FoodEntryService;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/food-entry")
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class FoodEntryController {

    private final FoodEntryService foodEntryService;

    public FoodEntryController(FoodEntryService foodEntryService) {
        this.foodEntryService = foodEntryService;
    }

    @PostMapping(value = "/save-food-entry", produces = MediaType.APPLICATION_JSON_VALUE)
    public FoodEntryDTO saveFoodEntry(@RequestBody CreationFoodEntryDTO creationFoodEntryDTO) {

        Assert.notNull(creationFoodEntryDTO, "creationFoodEntryDTO should not be null");
        Assert.notNull(creationFoodEntryDTO.getFoodEntry(), "food should not be null");
        Assert.notNull(creationFoodEntryDTO.getFoodEntryDate(), "date should not be null");
        Assert.notNull(creationFoodEntryDTO.getUpdatedTime(), "updated date should not be null");

        return foodEntryService.saveFoodEntry(creationFoodEntryDTO);
    }

    @DeleteMapping(value = "/delete-food-entry/{foodEntryId}")
    public void deleteFoodEntry(@PathVariable Integer foodEntryId) {
        Assert.notNull(foodEntryId, "foodEntryId should not be null");

        foodEntryService.deleteFoodEntry(foodEntryId);
    }

    @GetMapping(value = "/get-all-food-entries", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FoodEntryDTO> getAllFoodEntries() {
        return foodEntryService.getAllEntries();
    }

    @GetMapping(value = "/get-food-entries/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FoodEntryDTO> getDateFoodEntries(@PathVariable String date) {
        return foodEntryService.getDateFoodEntries(date);
    }

    @GetMapping(value = "/search-food-entries/{stringSearch}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FoodEntryDTO> searchFoodEntries(@PathVariable String stringSearch) {
        return foodEntryService.searchFoodEntries(stringSearch);
    }

    @GetMapping(value = "/search-food-tags/{stringSearch}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FoodEntryDTO> searchFoodTags(@PathVariable String stringSearch) {
        return foodEntryService.searchFoodTags(stringSearch);
    }

    @PostMapping(value = "/update-food-entry")
    public void updateFoodEntry(@RequestBody FoodEntryDTO foodEntryDTO) {
        Assert.notNull(foodEntryDTO.getId(), "foodEntryId should not be null");
        Assert.notNull(foodEntryDTO.getFoodEntry(), "food should not be null");

        foodEntryService.updateFoodEntry(foodEntryDTO);
    }
}
