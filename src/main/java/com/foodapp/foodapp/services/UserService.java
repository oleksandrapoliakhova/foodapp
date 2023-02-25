package com.foodapp.foodapp.services;

import com.foodapp.foodapp.dto.UserDTO;
import com.foodapp.foodapp.entity.User;
import com.foodapp.foodapp.mappers.UserMapper;
import com.foodapp.foodapp.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final UserRepo userRepo;

    public UserService(UserMapper userMapper, UserRepo userRepo) {
        this.userMapper = userMapper;
        this.userRepo = userRepo;
    }

    public void saveUser(String password, String email) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);
        userDTO.setPassword(password);

        User user = userMapper.mapDtoToEntity(userDTO);

        userRepo.save(user);

    }

    public List<UserDTO> getUsers() {
        List<User> userList = userRepo.findAll();
        return userList.stream()
                .map(userMapper::maoEntityToDTO).collect(Collectors.toList());
    }
}
