package com.queststore.util;

import com.queststore.dto.UserDto;
import com.queststore.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component

public class UserToUserDtoConverter {


    public UserDto convert(User user){
        return new UserDto(user.getUserId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getPhotoUrl(),
                user.getPhoneNumber(),
                user.getUserType());
    }

    public List<UserDto> convertAll(List<User> users){
        return users.stream().map(this::convert).collect(Collectors.toList());
    }
}
