package com.queststore.backDoor;

import com.queststore.dto.UserDto;
import com.queststore.service.UserService;
import com.queststore.util.UserDtoToUserConverter;
import com.queststore.util.UserToUserDtoConverter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class OrderUser {

    private UserService userService;
    private UserToUserDtoConverter userToUserDtoConverter;
    private UserDtoToUserConverter userDtoToUserConverter;



    @GetMapping
    public List<UserDto> getAllUsers(){
       return userToUserDtoConverter.convertAll(userService.getAllMentors());
    }

    @PostMapping
    public void addMentor(@RequestBody UserDto userDto){
        userService.saveMentor(userDtoToUserConverter.convert(userDto));

    }

}
