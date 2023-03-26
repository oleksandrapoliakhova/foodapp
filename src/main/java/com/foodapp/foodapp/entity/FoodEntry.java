package com.foodapp.foodapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FOOD_ENTRY")
public class FoodEntry {

    @Id
    @GeneratedValue
    private Integer id;

    private String foodEntry;

    private LocalDate foodEntryDay;

    @UpdateTimestamp
    @Temporal(TemporalType.TIME)
    private LocalTime updatedTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

//
//    @OneToMany(mappedBy = "food_entry_id")
//    private List<FoodTag> foodTagList;

}
