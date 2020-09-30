package com.queststore.controller;

import com.queststore.model.User;
import com.queststore.service.MentorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MentorController {

    MentorService mentorService;

    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @GetMapping("/mentors_list")
    public String allMentorsList(Model model, @SessionAttribute("loggedUser") User loggedUser){
        model.addAttribute("mentors", mentorService.getAllMentors());
        return "mentor/mentors_list";
    }

    @GetMapping("/add_mentor")
    public String addNewMentor(User user, @SessionAttribute("loggedUser") User loggedUser){
    return "mentor/add_mentor";
    };

    @PostMapping("/add_mentor")
    public String addTheMentor(Model model, @Valid User mentor){
        mentorService.createMentor(mentor);
        return "redirect:/mentors_list";
    }

    @GetMapping("/mentor_edit/{id}")
        public String mentorEdition(@PathVariable("id") long id, Model model, @SessionAttribute("loggedUser") User loggedUser){
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
    public String deleteTheMentor(@PathVariable("id") long id, Model model, @SessionAttribute("loggedUser") User loggedUser){
        mentorService.deleteTheMentor(id);
        return "redirect:/mentors_list";
    }

    @ExceptionHandler(ServletRequestBindingException.class)
    public String handle() {
        return "redirect:/index";
    }
}
