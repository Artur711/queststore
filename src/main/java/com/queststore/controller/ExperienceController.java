package com.queststore.controller;

import com.queststore.model.Experience;
import com.queststore.model.User;
import com.queststore.service.ExperienceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;

@Controller
public class ExperienceController {

    private final ExperienceService service;

    public ExperienceController(ExperienceService service) {
        this.service = service;
    }

    @GetMapping("/experiences")
    public String getExperience(Model model) {
        model.addAttribute("experience", service.getExperience());
        model.addAttribute("level", new Experience());
        return "other/experiences_levels";
    }

    @PostMapping("add_level")
    public String create(@ModelAttribute Experience level) {
        service.create(level);
        return "redirect:/experiences";
    }

    @GetMapping("/delete_level/{id}")
    public String removeLevel(@PathVariable("id") int id, Model model) {
        service.delete(id);
        model.addAttribute("experience", service.getExperience());
        return "redirect:/experiences";
    }
}
