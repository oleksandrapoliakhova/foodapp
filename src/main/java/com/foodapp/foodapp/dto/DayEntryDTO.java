package com.foodapp.foodapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DayEntryDTO {

    public String id;

    private LocalDate timeStamp;

    private List<FoodEntryDTO> foodEntryList;
}
