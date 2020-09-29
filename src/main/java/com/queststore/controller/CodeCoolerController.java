package com.queststore.controller;

import com.queststore.model.Codecoolers;
import com.queststore.service.CodeCoolerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CodeCoolerController {

    private CodeCoolerService service;

    public CodeCoolerController(CodeCoolerService service) {
        this.service = service;
    }

    @GetMapping("/student_list")
    public String getStudentsList(Model model){
        model.addAttribute("students", service.getAll());
        return "student_list";
    }


    @GetMapping("/add_codecooler")
    public String addTheCodeCooler(Codecoolers codecooler){
        return "add_codecooler";
    }

    @PostMapping("/add_codecooler")
    public String addCodeCooler(Model model, @Valid Codecoolers codecoolers){
        service.create(codecoolers);
        model.addAttribute("codecoolers", service.getAll());
        return "redirect:/student_list";
    }

    @GetMapping("/edit/{id}")
    public String editTheCodeCooler(@PathVariable("id") long id, Model model) {
        Codecoolers codecooler = service.getByID(id);
        model.addAttribute("codecooler", codecooler);
        return "update_student";
    }

    @PostMapping("/update/{id}")
    public String updateCodeCooler(@PathVariable("id") long id, @Valid Codecoolers codecooler, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "update_student";
        }
        codecooler.setCodecooler_id(id);
        codecooler.setUser_id(service.getByID(id).getUser_id());
        service.update(codecooler);
        model.addAttribute("students", service.getAll());;
        return "redirect:/student_list";
    }

    @GetMapping("/delete/{id}")
    public String removeCodeCooler(@PathVariable("id") long id, Model model) {
        System.out.println(id);
        service.delete(id);
        model.addAttribute("students", service.getAll());
        return "redirect:/student_list";
    }
}
