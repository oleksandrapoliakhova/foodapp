package com.foodapp.foodapp.mappers;

import com.foodapp.foodapp.dto.UserDTO;
import com.foodapp.foodapp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    public User mapDtoToEntity(UserDTO userDTO) {
        User user = new User();

        user.setUserId(ObjectId.get());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        return user;
    }


    public UserDTO maoEntityToDTO(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setUserId(user.getUserId());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());

        return userDTO;
    }

}
