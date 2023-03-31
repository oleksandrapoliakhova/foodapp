package com.foodapp.foodapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodEntryDTO implements Serializable {

    public Integer id;
    private String foodEntry;
    private LocalDate foodEntryDate;
    private LocalTime updatedTime;
    private List<FoodTagDTO> foodTagList;
}
