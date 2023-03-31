package com.foodapp.foodapp.services;

import com.foodapp.foodapp.entity.FoodEntry;
import com.foodapp.foodapp.entity.User;
import com.foodapp.foodapp.repository.FoodEntryRepo;
import com.foodapp.foodapp.types.FoodTagColor;
import com.foodapp.foodapp.dto.FoodTagDTO;
import com.foodapp.foodapp.entity.FoodTag;
import com.foodapp.foodapp.mappers.FoodTagMapper;
import com.foodapp.foodapp.repository.FoodTagRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodTagService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FoodTagService.class);

    private final FoodTagMapper foodTagMapper;
    private final FoodTagRepo foodTagRepo;
    private FoodEntryRepo foodEntryRepo;

    public FoodTagService(FoodTagMapper foodTagMapper,
                          FoodTagRepo foodTagRepo,
                          FoodEntryRepo foodEntryRepo) {
        this.foodTagMapper = foodTagMapper;
        this.foodTagRepo = foodTagRepo;
        this.foodEntryRepo = foodEntryRepo;
    }

    public FoodEntry appendFoodTagToEntry (List<Integer> foodTagIds, Integer foodEntryId) {

        LOGGER.debug("Updating food entry {}", foodEntryId);

        FoodEntry foodEntry = foodEntryRepo.findById(foodEntryId).orElse(null);
        List<FoodTag> foodTagList = foodTagRepo.findAllById(foodTagIds);

        if(foodEntry != null) {
            foodEntry.getFoodTagList().addAll(foodTagList);
            return foodEntryRepo.save(foodEntry);
        }

        return null;
    }

    public void saveFoodTag(String foodTagName, FoodTagColor foodTagColor) {

        LOGGER.debug("Saving food tag {}", foodTagName);

        FoodTagDTO foodTagDTO = new FoodTagDTO();
        foodTagDTO.setFoodTagName(foodTagName);
        foodTagDTO.setActiveInd(true);
        foodTagDTO.setFoodTagColor(foodTagColor);

        FoodTag foodTag = foodTagMapper.mapDtoToEntity(foodTagDTO);

        // todo update dto?
        foodTag.setUser(getUserFromContext());

        foodTagRepo.save(foodTag);
    }

    // todo: delete the ones with no entries and delete if are more than one year old
    public void deleteFoodTag (Integer foodTagId) {

        LOGGER.debug("Deleting food tag {}", foodTagId);

        Optional<FoodTag> foodTag = foodTagRepo.findById(foodTagId);
        if (foodTag.isPresent()) {
            foodTag.get().setActiveInd(false);
            foodTagRepo.save(foodTag.get());
        }
    }

    public List<FoodTagDTO> getAllFoodTags() {
        User user = getUserFromContext();

        List<FoodTag> foodTagList = foodTagRepo.findAllByUserId(user.getId());

        return foodTagList
                .stream().filter(FoodTag::isActiveInd)
                .map(foodTagMapper::mapEntityToDto).collect(Collectors.toList());
    }

    /**
     * Helper method to ger the user
     * @return User
     */
    private static User getUserFromContext() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
