package com.foodapp.foodapp.entity;

import com.foodapp.foodapp.types.FoodTagColor;
import jakarta.persistence.*;
import lombok.*;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FOOD_TAG")
public class FoodTag {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Integer id;

    private String foodTagName;

    @Enumerated(EnumType.STRING)
    private FoodTagColor foodTagColor;
}
