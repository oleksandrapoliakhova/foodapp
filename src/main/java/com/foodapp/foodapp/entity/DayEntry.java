package com.foodapp.foodapp.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document
@AllArgsConstructor
public class DayEntry {

    @Id
    private ObjectId id;
    private LocalDateTime timeStamp;
    // private List<FoodEntry> foodEntryList;

}
