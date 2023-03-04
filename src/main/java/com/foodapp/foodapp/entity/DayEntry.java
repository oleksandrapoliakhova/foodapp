package com.foodapp.foodapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Document
@AllArgsConstructor
@NoArgsConstructor
public class DayEntry {

    @Id
    public String id;

    private LocalDate date;

    private List<FoodEntry> foodEntryList;

}
