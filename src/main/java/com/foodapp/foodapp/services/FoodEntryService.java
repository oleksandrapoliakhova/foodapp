package com.foodapp.foodapp.services;

import com.foodapp.foodapp.dto.FoodEntryDTO;
import com.foodapp.foodapp.dto.FoodTagDTO;
import com.foodapp.foodapp.entity.DayEntry;
import com.foodapp.foodapp.entity.FoodEntry;
import com.foodapp.foodapp.mappers.DayEntryMapper;
import com.foodapp.foodapp.mappers.FoodEntryMapper;
import com.foodapp.foodapp.repository.DayEntryRepo;
import com.foodapp.foodapp.repository.FoodEntryRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FoodEntryService {

    private FoodEntryMapper foodEntryMapper;
    private FoodEntryRepo foodEntryRepo;
    private DayEntryRepo dayEntryRepo;

    public FoodEntryService(FoodEntryMapper foodEntryMapper, FoodEntryRepo foodEntryRepo, DayEntryRepo dayEntryRepo) {
        this.foodEntryMapper = foodEntryMapper;
        this.foodEntryRepo = foodEntryRepo;
        this.dayEntryRepo = dayEntryRepo;
    }

    public void saveFoodEntry(String food, List<FoodTagDTO> foodTagList, LocalDate date) {

        DayEntry dayEntry = dayEntryRepo.findByDate(date);

        FoodEntryDTO foodEntryDTO = new FoodEntryDTO();
        foodEntryDTO.setFoodEntry(food);
        foodEntryDTO.setFoodTagList(foodTagList);
        foodEntryDTO.setLocalDate(LocalDateTime.now());

        FoodEntry foodEntry = foodEntryMapper.mapDtoToEntity(foodEntryDTO);
        foodEntryRepo.save(foodEntry);

    }

    public void deleteFoodEntry(String foodEntryId) {
    }
}
