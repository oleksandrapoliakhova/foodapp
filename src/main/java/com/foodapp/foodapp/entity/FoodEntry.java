package com.foodapp.foodapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
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
    private Integer id;

    private String foodEntry;

    private LocalDate foodEntryDay;

    @UpdateTimestamp
    @Temporal(TemporalType.TIME)
    private LocalTime updatedTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "FOOD_ENTRY_TAG_ASSOC",
            joinColumns = {@JoinColumn(name = "FOOD_ENTRY_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "FOOD_TAG_ID", referencedColumnName = "ID")})
    private List<FoodTag> foodTagList;
}
