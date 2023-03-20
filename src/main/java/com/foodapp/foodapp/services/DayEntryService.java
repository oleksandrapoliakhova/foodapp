package com.foodapp.foodapp.services;

import com.foodapp.foodapp.dto.DayEntryDTO;
import com.foodapp.foodapp.entity.DayEntry;
import com.foodapp.foodapp.mappers.DayEntryMapper;
import com.foodapp.foodapp.repository.DayEntryRepo;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DayEntryService {

    private DayEntryRepo dayEntryRepo;
    private DayEntryMapper dayEntryMapper;

    public DayEntryService(DayEntryRepo dayEntryRepo, DayEntryMapper dayEntryMapper) {
        this.dayEntryRepo = dayEntryRepo;
        this.dayEntryMapper = dayEntryMapper;
    }

    public DayEntryDTO getDayEntry(String dayEntryId) {

        DayEntry dayEntry = dayEntryRepo.findById(dayEntryId);
        return dayEntryMapper.mapEntityToDTO(dayEntry);
    }

    public List<DayEntryDTO> getAllDateEntries() {

        List<DayEntry> dayEntries = dayEntryRepo.findAll();
        return CollectionUtils.emptyIfNull(dayEntries)
                .stream().map(d -> dayEntryMapper.mapEntityToDTO(d)).collect(Collectors.toList());
    }
}
