package com.foodapp.foodapp.services;

import com.foodapp.foodapp.dto.FoodTagDTO;
import com.foodapp.foodapp.entity.FoodEntry;
import com.foodapp.foodapp.entity.FoodTag;
import com.foodapp.foodapp.entity.User;
import com.foodapp.foodapp.mappers.FoodTagMapper;
import com.foodapp.foodapp.repository.FoodEntryRepo;
import com.foodapp.foodapp.repository.FoodTagRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodTagService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FoodTagService.class);

    private final FoodTagMapper foodTagMapper;
    private final FoodTagRepo foodTagRepo;
    private final FoodEntryRepo foodEntryRepo;

    public FoodTagService(FoodTagMapper foodTagMapper,
                          FoodTagRepo foodTagRepo,
                          FoodEntryRepo foodEntryRepo) {
        this.foodTagMapper = foodTagMapper;
        this.foodTagRepo = foodTagRepo;
        this.foodEntryRepo = foodEntryRepo;
    }

    /**
     * Helper method to ger the user
     *
     * @return User
     */
    private static User getUserFromContext() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public FoodEntry appendFoodTagToEntry(List<String> foodTagIds, Integer foodEntryId) {

        LOGGER.debug("Appending food tag id {} to food entry {}", foodTagIds, foodEntryId);

        FoodEntry foodEntry = foodEntryRepo.findById(foodEntryId).orElse(null);

        List<Integer> integers = new ArrayList<>();
        foodTagIds.forEach(f -> integers.add(Integer.valueOf(f)));
        List<FoodTag> foodTagList = foodTagRepo.findAllById(integers);

        if (foodEntry != null) {
            foodTagList.forEach(ft -> {
                if (!foodEntry.getFoodTagList().contains(ft)) {
                    foodEntry.getFoodTagList().add(ft);
                } else {
                    LOGGER.debug("Food Tag already exist {}", ft);
                }
            });

            return foodEntryRepo.save(foodEntry);
        }

        return null;
    }

    public FoodEntry deleteFoodTagsFromEntry(String foodEntryId) {

        LOGGER.debug("Deleting food tags to food entry {}", foodEntryId);

        FoodEntry foodEntry = foodEntryRepo.findById(Integer.valueOf(foodEntryId)).orElse(null);
        if (foodEntry != null) {

            foodEntry.getFoodTagList().clear();
            return foodEntryRepo.save(foodEntry);
        }

        return null;
    }

    public FoodTagDTO saveFoodTag(String foodTagName, String foodTagColor) {

        LOGGER.debug("Saving food tag {}", foodTagName);

        FoodTagDTO foodTagDTO = new FoodTagDTO();
        foodTagDTO.setFoodTagName(foodTagName);
        foodTagDTO.setActiveInd(true);

        foodTagDTO.setFoodTagColor(foodTagColor);

        FoodTag foodTag = foodTagMapper.mapDtoToEntity(foodTagDTO);

        foodTag.setUser(getUserFromContext());
        FoodTag savedFoodTag = foodTagRepo.save(foodTag);

        return foodTagMapper.mapEntityToDto(savedFoodTag);

    }

    public List<FoodTagDTO> getAllFoodTags() {
        User user = getUserFromContext();

        List<FoodTag> foodTagList = foodTagRepo.findAllByUserId(user.getId());

        return foodTagList
                .stream().filter(FoodTag::isActiveInd)
                .map(foodTagMapper::mapEntityToDto).collect(Collectors.toList());
    }

    // todo: delete the ones with no entries and delete if are more than one year old
    public void deleteFoodTag(Integer foodTagId) {

        LOGGER.debug("Deleting food tag {}", foodTagId);

        Optional<FoodTag> foodTag = foodTagRepo.findById(foodTagId);
        if (foodTag.isPresent()) {

            foodTag.get().setActiveInd(false);
            foodTagRepo.save(foodTag.get());
        } else {
            LOGGER.debug("Food tag id {} is not found", foodTagId);
        }
    }

}
