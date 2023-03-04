package com.foodapp.foodapp.entity;

import lombok.*;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    public String id;

    @NonNull
    private String email;

    @NonNull
    private String password;

    private List<DayEntry> dayEntryList;

}
