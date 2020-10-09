package com.queststore.controller;

import com.queststore.model.User;
import com.queststore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MentorController {

    private UserService userService;

    public MentorController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/mentors_list")
    public String allMentorsList(Model model){
        model.addAttribute("mentors", userService.getAllMentors());
        return "mentor/mentors_list";
    }

    @GetMapping("/add_mentor")
    public String addNewMentor(User user){
    return "mentor/add_mentor";
    }

    @PostMapping("/add_mentor")
    public String addTheMentor(Model model, @Valid User user){
        User newUser = new User();
        user.setUserId(newUser.getUserId());
        userService.crateMentor(user);
        return "redirect:/mentors_list";
    }

    @GetMapping("/mentor_edit/{id}")
        public String mentorEdition(@PathVariable("id") long id, Model model){
        User mentor = userService.getUserById(id);
        model.addAttribute("user", mentor);
        return "mentor/update_mentor";
    }

    @PostMapping("/mentor_edit/{id}")
    public String updateTheMentor(@PathVariable("id") long id, @Valid User mentor){
        mentor.setUserId(id);
        userService.updateMentor(mentor);
        return "redirect:/mentors_list";
    }

    @GetMapping("/mentor_delete/{id}")
    public String deleteTheMentor(@PathVariable("id") long id){
        userService.deleteUser(id);
        return "redirect:/mentors_list";
    }
}
