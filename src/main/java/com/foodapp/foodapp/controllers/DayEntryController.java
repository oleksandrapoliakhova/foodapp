package com.foodapp.foodapp.controllers;

import com.foodapp.foodapp.dto.DayEntryDTO;
import com.foodapp.foodapp.services.DayEntryService;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

import static com.foodapp.foodapp.ApiConstants.GET_FOOD_ENTRIES;

@RestController
@RequestMapping("/day-entry")
public class DayEntryController {

    private DayEntryService dayEntryService;

    public DayEntryController(DayEntryService dayEntryService) {
        this.dayEntryService = dayEntryService;
    }

    @PostMapping(value = GET_FOOD_ENTRIES)
    public DayEntryDTO getFoodEntries(@PathVariable LocalDate date) {
        Assert.notNull(date, "date should not be null");
        return dayEntryService.getFoodEntries(date);
    }
}
