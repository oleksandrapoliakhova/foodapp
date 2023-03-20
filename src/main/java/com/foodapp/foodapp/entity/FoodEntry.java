package com.foodapp.foodapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FOOD_ENTRY")
public class FoodEntry {

    @Id
    @GeneratedValue
    public Integer id;

    private String foodEntry;

    private LocalDateTime updatedTime;

    //private List<FoodTag> foodTagList;

}
