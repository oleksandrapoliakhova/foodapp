package com.foodapp.foodapp.controllers;

import com.foodapp.foodapp.dto.DayEntryDTO;
import com.foodapp.foodapp.services.DayEntryService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.foodapp.foodapp.ApiConstants.GET_ALL_DAY_ENTRIES;
import static com.foodapp.foodapp.ApiConstants.GET_DAY_ENTRY;

@RestController
@RequestMapping("/day-entry")
public class DayEntryController {

    private DayEntryService dayEntryService;

    public DayEntryController(DayEntryService dayEntryService) {
        this.dayEntryService = dayEntryService;
    }

    @GetMapping(value = GET_DAY_ENTRY)
    public DayEntryDTO getDayEntry(@PathVariable String dayEntryId) {
        Assert.notNull(dayEntryId, "dayEntryId should not be null");
        return dayEntryService.getDayEntry(dayEntryId);
    }

    @GetMapping(value = GET_ALL_DAY_ENTRIES)
    public List<DayEntryDTO> getAllDayEntries() {
        return dayEntryService.getAllDateEntries();
    }
}
