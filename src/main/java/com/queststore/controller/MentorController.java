package com.queststore.controller;

import com.queststore.model.User;
import com.queststore.service.MentorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        return "mentor/mentors_list";
    }

    @GetMapping("/add_mentor")
    public String addNewMentor(User user){
    return "mentor/add_mentor";
    };

    @PostMapping("/add_mentor")
    public String addTheMentor(Model model, @Valid User mentor){
        mentorService.createMentor(mentor);
        return "redirect:/mentors_list";
    }

    @GetMapping("/mentor_edit/{id}")
        public String mentorEdition(@PathVariable("id") long id, Model model){
        User mentor = mentorService.getMentorById(id);
        model.addAttribute("user", mentor);
        return "mentor/update_mentor";
    }

    @PostMapping("/mentor_edit/{id}")
    public String updateTheMentor(@PathVariable("id") long id, @Valid User mentor){
        mentor.setUserId(id);
        mentorService.updateMentor(mentor);
        return "redirect:/mentors_list";
    }

    @GetMapping("/mentor_delete/{id}")
    public String deleteTheMentor(@PathVariable("id") long id, Model model){
        mentorService.deleteTheMentor(id);
        return "redirect:/mentors_list";
    }
}
