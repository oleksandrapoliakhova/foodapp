package com.foodapp.foodapp.repository;

import com.foodapp.foodapp.entity.DayEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface DayEntryRepo extends MongoRepository<DayEntry, Long> {

    DayEntry findById(String dayEntryId);

    DayEntry findByDate(LocalDate date);

}
