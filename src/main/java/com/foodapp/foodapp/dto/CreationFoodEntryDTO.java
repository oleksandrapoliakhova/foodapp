package com.foodapp.foodapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreationFoodEntryDTO implements Serializable {

    private String foodEntry;
    private String foodEntryDate;
    private String updatedTime;
}
