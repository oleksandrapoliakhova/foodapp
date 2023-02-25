package com.foodapp.foodapp.dto;

import com.foodapp.foodapp.entity.FoodEntry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class DayEntryDTO {

    private Long id;
    private LocalDateTime timeStamp;
    private List<FoodEntry> foodEntryList;
}
