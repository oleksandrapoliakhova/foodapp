package com.foodapp.foodapp.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
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

    public Integer id;

    private LocalDate timeStamp;

    private List<FoodEntryDTO> foodEntryList;
}
