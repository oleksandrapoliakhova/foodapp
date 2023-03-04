package com.foodapp.foodapp;

public class ApiConstants {

    // day entry
    public static final String GET_FOOD_ENTRIES = "/get-food-entries/{date}";

    // food entry
    public static final String SAVE_FOOD_ENTRY = "/save-food-entry/{food}";
    public static final String DELETE_FOOD_ENTRY = "/delete-food-entry/{foodEntryId}";
    public static final String UPDATE_FOOD_ENTRY = "/update-food-entry/{foodEntryId}/{food}";

    // food tag
    public static final String DELETE_FOOD_TAG = "/delete-food-tag/{foodTagId}";
    public static final String SAVE_FOOD_TAG = "/save-food-tag/{foodTagName}/{foodTagColor}";
    public static final String GET_FOOD_TAGS = "/get-food-tags/{foodEntryId}";

    // user
    public static final String GET_USERS = "/get-users";
    public static final String SAVE_USER_URL = "/save-user/{password}/{email}";

}
