package com.foodapp.foodapp.dto;

import com.foodapp.foodapp.entity.FoodTag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodEntryDTO {

    public String id;

    private String foodEntry;

    private LocalDateTime localDate;

    private List<FoodTagDTO> foodTagList;

}
