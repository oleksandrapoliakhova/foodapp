package com.foodapp.foodapp.controllers;

import com.foodapp.foodapp.dto.DayEntryDTO;
import com.foodapp.foodapp.services.DayEntryService;
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
class DayEntryControllerTest {

    @Mock
    private DayEntryService dayEntryService;

    private DayEntryController dayEntryController;

    @BeforeEach
    void init() {
        dayEntryController = new DayEntryController(dayEntryService);
    }

    @Test
    void getAllDayEntries() {
        List<DayEntryDTO> dayEntryDTO1 = Collections.singletonList(new DayEntryDTO());
        when(dayEntryService.getAllDateEntries()).thenReturn(dayEntryDTO1);

        List<DayEntryDTO> dayEntryDTO2 = dayEntryController.getAllDayEntries();

        assertEquals(dayEntryDTO1, dayEntryDTO2);
        assertEquals(dayEntryDTO1.size(), 1);
    }
}
