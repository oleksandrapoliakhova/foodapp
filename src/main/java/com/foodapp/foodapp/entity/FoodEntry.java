package com.foodapp.foodapp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "FOOD_ENTRY_TAG_ASSOC",
            joinColumns = {@JoinColumn(name = "FOOD_TAG_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "FOOD_ENTRY_ID", referencedColumnName = "ID")})
    private List<FoodTag> foodTagList;
}
