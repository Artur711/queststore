package com.queststore.service;

import com.queststore.model.User;
import com.queststore.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllMentors() {
        List<User> userList = (List<User>) userRepository.findAll();
        return userList.stream().filter(user -> user.getUserType() == 2).collect(Collectors.toList());
    }

    public List<User> getAllAdmins() {
        List<User> userList = (List<User>) userRepository.findAll();
        return userList.stream().filter(user -> user.getUserType() == 3).collect(Collectors.toList());
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void saveMentor(User mentor) {
        mentor.setUserType(2);
        userRepository.save(mentor);
    }

    public void saveAdmin(User admin) {
        admin.setUserType(3);
        userRepository.save(admin);
    }

    public User getUserById(long id){
        List<User> userList = (List<User>) userRepository.findAll();
        return userList.stream().filter(user -> user.getUserId() == id).findAny().orElse(null);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
