package com.foodapp.foodapp.controllers;

import com.foodapp.foodapp.dto.UserDTO;
import com.foodapp.foodapp.services.UserService;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.foodapp.foodapp.ApiConstants.*;

@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = SAVE_USER_URL)
    public void saveUser(@PathVariable String password, @PathVariable String email) {
        Assert.notNull(password , "password should not be null");
        Assert.notNull(email , "email should not be null");

        userService.saveUser(password, email);
    }

    @GetMapping(value = GET_USERS)
    public List<UserDTO> getUsers() {
       return userService.getUsers();
    }
}
