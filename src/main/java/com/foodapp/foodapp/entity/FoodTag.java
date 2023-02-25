package com.foodapp.foodapp.entity;

import com.foodapp.foodapp.FoodTagColor;
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
public class FoodTag {

    private ObjectId id;
    private String foodTagName;
    private String foodTagColor;

}
