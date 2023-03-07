package com.foodapp.foodapp.entity;

import lombok.*;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Document
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 7428051251365675318L;

    @Id
    public String id;

    @NonNull
    private String email;

    @NonNull
    private String password;

    private List<DayEntry> dayEntryList;

}
