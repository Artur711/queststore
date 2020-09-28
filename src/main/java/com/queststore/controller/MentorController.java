package com.queststore.controller;

import com.queststore.model.User;
import com.queststore.service.MentorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;

@Controller
public class MentorController {

    MentorService mentorService;

    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @GetMapping("/mentors_list")
    public String allMentorsList(Model model){
        model.addAttribute("mentors", mentorService.getAllMentors());
        return "mentors_list";
    }

//    @GetMapping("/add_mentor")
//    public String addNewMentor(Model modecl, @Valid User mentor){
//
//    };
}
