package com.foodapp.foodapp.repository;

import com.foodapp.foodapp.entity.DayEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface DayEntryRepo extends JpaRepository<DayEntry, Integer> {

    DayEntry findById(String dayEntryId);

    DayEntry findByDate(LocalDate date);

}
