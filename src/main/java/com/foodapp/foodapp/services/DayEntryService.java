package com.foodapp.foodapp.services;

import com.foodapp.foodapp.dto.DayEntryDTO;
import com.foodapp.foodapp.entity.DayEntry;
import com.foodapp.foodapp.mappers.DayEntryMapper;
import com.foodapp.foodapp.repository.DayEntryRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DayEntryService {

    private DayEntryRepo dayEntryRepo;
    private DayEntryMapper dayEntryMapper;

    public DayEntryService(DayEntryRepo dayEntryRepo, DayEntryMapper dayEntryMapper) {
        this.dayEntryRepo = dayEntryRepo;
        this.dayEntryMapper = dayEntryMapper;
    }

    public DayEntryDTO getFoodEntries(LocalDate date) {

        DayEntry dayEntry  = dayEntryRepo.findByDate(date);

        return dayEntryMapper.mapEntityToDTO(dayEntry);
    }
}
