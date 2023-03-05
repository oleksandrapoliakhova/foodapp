package com.foodapp.foodapp.services;

import com.foodapp.foodapp.dto.FoodEntryDTO;
import com.foodapp.foodapp.dto.FoodTagDTO;
import com.foodapp.foodapp.entity.DayEntry;
import com.foodapp.foodapp.entity.FoodEntry;
import com.foodapp.foodapp.entity.FoodTag;
import com.foodapp.foodapp.mappers.FoodEntryMapper;
import com.foodapp.foodapp.mappers.FoodTagMapper;
import com.foodapp.foodapp.repository.DayEntryRepo;
import com.foodapp.foodapp.repository.FoodTagRepo;
import org.apache.commons.collections4.CollectionUtils;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodEntryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FoodEntryService.class);

    private FoodEntryMapper foodEntryMapper;
    private DayEntryRepo dayEntryRepo;
    private FoodTagRepo foodTagRepo;
    private FoodTagMapper foodTagMapper;

    public FoodEntryService(FoodEntryMapper foodEntryMapper, DayEntryRepo dayEntryRepo, FoodTagRepo foodTagRepo, FoodTagMapper foodTagMapper) {
        this.foodEntryMapper = foodEntryMapper;
        this.dayEntryRepo = dayEntryRepo;
        this.foodTagRepo = foodTagRepo;
        this.foodTagMapper = foodTagMapper;
    }

    public void saveFoodEntry(String food, List<String> foodTagIdList, String date) {

        LocalDate localDate = LocalDate.parse(date);
        DayEntry dayEntry = dayEntryRepo.findByDate(localDate);

        FoodEntryDTO foodEntryDTO = getFoodEntryDTO(food, foodTagIdList);
        FoodEntry foodEntry = foodEntryMapper.mapDtoToEntity(foodEntryDTO);

        if (dayEntry == null) {
            dayEntry = new DayEntry();
            dayEntry.setDate(localDate);
            dayEntry.setFoodEntryList(Collections.singletonList(foodEntry));
            dayEntryRepo.save(dayEntry);
        } else {
            dayEntry.getFoodEntryList().add(foodEntry);
            dayEntryRepo.save(dayEntry);
        }
    }

    private FoodEntryDTO getFoodEntryDTO(String food, List<String> foodTagIdList) {

        FoodEntryDTO foodEntryDTO = new FoodEntryDTO();
        foodEntryDTO.setFoodEntry(food);
        foodEntryDTO.setId(ObjectId.get().toHexString());

        List<FoodTag> foodTags = CollectionUtils.emptyIfNull(foodTagIdList)
                .stream().map(f -> foodTagRepo.findById(f)).collect(Collectors.toList());
        List <FoodTagDTO> foodTagDTOS = CollectionUtils.emptyIfNull(foodTags)
                .stream().map(f -> foodTagMapper.mapEntityToDto(f)).collect(Collectors.toList());

        foodEntryDTO.setFoodTagList(foodTagDTOS);
        foodEntryDTO.setLocalDate(LocalDateTime.now());
        return foodEntryDTO;
    }

    public void deleteFoodEntry(String foodEntryId, String dayEntryId) {

        DayEntry dayEntry = dayEntryRepo.findById(dayEntryId);
        CollectionUtils.emptyIfNull(dayEntry.getFoodEntryList())
                .stream().filter(d -> d.getId().equalsIgnoreCase(foodEntryId))
                .findFirst().ifPresent(foodEntry -> dayEntry.getFoodEntryList().remove(foodEntry));
    }

    public void updateFoodEntry(String foodEntryId, String dayEntryId, String food, List<String> foodTagIdList) {

        DayEntry dayEntry = dayEntryRepo.findById(dayEntryId);
        FoodEntry foodEntry = CollectionUtils.emptyIfNull(dayEntry.getFoodEntryList())
                .stream().filter(d -> d.getId().equalsIgnoreCase(foodEntryId)).findFirst().orElse(null);

        List<FoodTag> foodTags = CollectionUtils.emptyIfNull(foodTagIdList)
                .stream().map(f -> foodTagRepo.findById(f)).collect(Collectors.toList());

        if (foodEntry != null) {
            foodEntry.setFoodEntry(food);
            foodEntry.setFoodTagList(foodTags);
            foodEntry.setUpdatedTime(LocalDateTime.now());
        } else {
            LOGGER.debug("Entry does not exist", foodEntryId);
        }

    }
}
