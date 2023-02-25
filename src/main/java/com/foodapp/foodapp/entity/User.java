package com.foodapp.foodapp.entity;

import lombok.*;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private ObjectId userId;

    @NonNull
    private String email;

    @NonNull
    private String password;

    // todo can it be a list?
    //private List<DayEntry> dayEntryList;

}
