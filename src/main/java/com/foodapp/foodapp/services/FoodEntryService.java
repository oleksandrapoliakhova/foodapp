package com.foodapp.foodapp.services;

import com.foodapp.foodapp.dto.CreationFoodEntryDTO;
import com.foodapp.foodapp.dto.FoodEntryDTO;
import com.foodapp.foodapp.entity.FoodEntry;
import com.foodapp.foodapp.entity.User;
import com.foodapp.foodapp.mappers.FoodEntryMapper;
import com.foodapp.foodapp.repository.FoodEntryRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodEntryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FoodEntryService.class);
    private final FoodEntryMapper foodEntryMapper;
    private final FoodEntryRepo foodEntryRepo;

    public FoodEntryService(FoodEntryMapper foodEntryMapper, FoodEntryRepo foodEntryRepo) {
        this.foodEntryMapper = foodEntryMapper;
        this.foodEntryRepo = foodEntryRepo;
    }

    public void saveFoodEntry(CreationFoodEntryDTO creationFoodEntryDTO) {
        LOGGER.debug("Saving food entry {}", creationFoodEntryDTO.getFoodEntry());
        User user = getUserFromContext();

        LocalDate localDate = LocalDate.parse(creationFoodEntryDTO.getFoodEntryDate());

        FoodEntry foodEntry = FoodEntry
                .builder()
                .foodEntry(creationFoodEntryDTO.getFoodEntry())
                .user(user)
                .foodEntryDay(localDate).build();

        foodEntryRepo.save(foodEntry);
    }

    public void deleteFoodEntry(Integer foodEntryId) {
        LOGGER.debug("Deleting food entry {}", foodEntryId);

        foodEntryRepo.deleteById(foodEntryId);
    }

    public List<FoodEntryDTO> getAllEntries() {
        User user = getUserFromContext();

        List<FoodEntry> foodEntries = foodEntryRepo.findAllByUserId(user.getId());

        return foodEntries.stream().map(foodEntryMapper::mapEntityToDTO).collect(Collectors.toList());
    }

    public void updateFoodEntry(FoodEntryDTO foodEntryDTO) {
        FoodEntry foodEntry = foodEntryMapper.mapDtoToEntity(foodEntryDTO);

        Optional<FoodEntry> foodEntrySaved = foodEntryRepo.findById(foodEntryDTO.getId());

        if (foodEntrySaved.isPresent()){
            FoodEntry foodEntryToSave = foodEntrySaved.get();
            foodEntryToSave.setFoodEntry(foodEntry.getFoodEntry());
            foodEntryRepo.save(foodEntryToSave);
        }
        else {
            LOGGER.debug("Food entry not found {}", foodEntry.getId());
        }
    }

    /**
     * Helper method to ger the user
     * @return User
     */
    private static User getUserFromContext() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
