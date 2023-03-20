package com.foodapp.foodapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DAY_ENTRY")
public class DayEntry {

    @Id
    @GeneratedValue
    public Integer id;

    private LocalDate date;

    //private List<FoodEntry> foodEntryList;

}
