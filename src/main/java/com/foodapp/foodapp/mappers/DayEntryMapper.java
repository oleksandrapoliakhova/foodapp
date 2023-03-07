package com.foodapp.foodapp.mappers;

import com.foodapp.foodapp.dto.DayEntryDTO;
import com.foodapp.foodapp.entity.DayEntry;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.Collectors;

@Component
public class DayEntryMapper {

    private FoodEntryMapper foodEntryMapper;

    public DayEntryMapper(FoodEntryMapper foodEntryMapper) {
        this.foodEntryMapper = foodEntryMapper;
    }

    public DayEntryDTO mapEntityToDTO(DayEntry dayEntry) {

        DayEntryDTO dayEntryDTO = new DayEntryDTO();
        dayEntryDTO.setTimeStamp(dayEntry.getDate());
        dayEntryDTO.setId(dayEntry.getId());
        dayEntryDTO.setFoodEntryList(CollectionUtils.emptyIfNull(dayEntry
                .getFoodEntryList())
                .stream().map(d -> foodEntryMapper
                        .mapEntityToDTO(d)).collect(Collectors.toList()));

        return dayEntryDTO;

    }

}
