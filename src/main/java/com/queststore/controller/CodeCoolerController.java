package com.queststore.controller;

import com.queststore.model.CodeCooler;
import com.queststore.service.CodeCoolerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CodeCoolerController {

    private final CodeCoolerService service;

    public CodeCoolerController(CodeCoolerService service) {
        this.service = service;
    }

    @GetMapping("/student_list")
    public String getStudentsList(Model model){
        List<CodeCooler> codeCoolerList = service.getAll();
        model.addAttribute("students", service.getAll());
        return "codecooler/student_list";
    }


    @GetMapping("/add_codecooler")
    public String addTheCodeCooler(Model model, CodeCooler codeCooler){
        model.addAttribute("codeCooler", codeCooler);
        return "codecooler/add_codecooler";
    }

    @PostMapping("/add_codecooler")
    public String addCodeCooler(Model model, @Valid CodeCooler codeCooler){
        service.create(codeCooler);
        model.addAttribute("codecoolers", service.getAll());
        return "redirect:/student_list";
    }

    @GetMapping("/edit/{id}")
    public String editTheCodeCooler(@PathVariable("id") long id, Model model) {
        CodeCooler codeCooler = service.getCodeCoolerById(id);
        model.addAttribute("codecooler", codeCooler);
        return "codecooler/update_student";
    }

    @PostMapping("/update/{id}")
    public String updateCodeCooler(@PathVariable("id") long id, @Valid CodeCooler codeCooler, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "codecooler/update_student";
        }
        codeCooler.setUserId(id);
        codeCooler.setUserId(service.getCodeCoolerById(id).getUserId());
        service.create(codeCooler);
        model.addAttribute("students", service.getAll());;
        return "redirect:/student_list";
    }

    @GetMapping("/delete/{id}")
    public String removeCodeCooler(@PathVariable("id") long id, Model model) {
        service.delete(id);
        model.addAttribute("students", service.getAll());
        return "redirect:/student_list";
    }
}
