package com.foodapp.foodapp;

public class ApiConstants {

    // day entry
    public static final String GET_DAY_ENTRY = "/get-day-entry/{dayEntryId}";
    public static final String GET_ALL_DAY_ENTRIES = "/get-all";

    // food entry
    public static final String SAVE_FOOD_ENTRY = "/save-food-entry/{food}/{date}";
    public static final String DELETE_FOOD_ENTRY = "/delete-food-entry/{foodEntryId}";
    public static final String UPDATE_FOOD_ENTRY = "/update-food-entry/{foodEntryId}/{food}";

    // food tag
    public static final String DELETE_FOOD_TAG = "/delete-food-tag/{foodTagId}";
    public static final String SAVE_FOOD_TAG = "/save-food-tag/{foodTagName}/{foodTagColor}";
    public static final String GET_ALL_FOOD_TAGS = "/get-all-food-tags";

    // user
    public static final String GET_USERS = "/get-users";
    public static final String REGISTER_USER_URL = "/register-user/{password}/{email}";
    public static final String LOGIN = "/login/{password}/{email}";
}
