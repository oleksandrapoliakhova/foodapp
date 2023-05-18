package com.foodapp.foodapp.entity;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
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

    private boolean activeInd;

    private String foodTagColor;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;
}
