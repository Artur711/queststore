package com.queststore.util;

import com.queststore.dto.UserDto;
import com.queststore.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoToUserConverter {

    public User convert(UserDto userDto){
        return new User(userDto.getUserId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getPhotoUrl(),
                userDto.getPhoneNumber(),
                userDto.getUserType());
    }

    public List<User> convertAll(List<UserDto> usersDto){
        return usersDto.stream().map(this::convert).collect(Collectors.toList());
    }
}
