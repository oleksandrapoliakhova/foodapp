package com.foodapp.foodapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodTagDTO {

    private Integer id;
    private String foodTagName;
    private String foodTagColor;
    private boolean activeInd;
}
