package com.foodapp.foodapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Document
@AllArgsConstructor
@NoArgsConstructor
public class FoodEntry {

    @Id
    public String id;

    private String foodEntry;

    private LocalDateTime updatedTime;

    private List<FoodTag> foodTagList;

}
