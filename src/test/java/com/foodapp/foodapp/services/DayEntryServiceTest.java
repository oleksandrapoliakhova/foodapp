package com.foodapp.foodapp.services;

import com.foodapp.foodapp.dto.DayEntryDTO;
import com.foodapp.foodapp.entity.DayEntry;
import com.foodapp.foodapp.mappers.DayEntryMapper;
import com.foodapp.foodapp.mappers.FoodEntryMapper;
import com.foodapp.foodapp.mappers.FoodTagMapper;
import com.foodapp.foodapp.repository.DayEntryRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DayEntryServiceTest {

    @Mock
    private DayEntryRepo dayEntryRepo;

    private DayEntryMapper dayEntryMapper;

    // class under test:
    private DayEntryService dayEntryService;

    @BeforeEach
    void setUp() {
        dayEntryMapper = new DayEntryMapper(new FoodEntryMapper(new FoodTagMapper()));
        dayEntryService = new DayEntryService(dayEntryRepo, dayEntryMapper);
    }

    @Test
    void getAllDateEntries() {

        List<DayEntry> dayEntries = Collections.singletonList(new DayEntry());
        when(dayEntryRepo.findAll()).thenReturn(dayEntries);

        List<DayEntryDTO> list = dayEntryService.getAllDateEntries();

        assertEquals(1, list.size());
    }
}
