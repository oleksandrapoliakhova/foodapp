package com.foodapp.foodapp.entity;

import com.foodapp.foodapp.FoodTagColor;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
@AllArgsConstructor
@NoArgsConstructor
public class FoodTag {

    @Id
    public String id;

    private String foodTagName;

    private FoodTagColor foodTagColor;

}
