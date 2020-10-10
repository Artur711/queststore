package com.queststore.controller;

import com.queststore.model.User;
import com.queststore.service.CodeCoolerItemsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class CodeCoolerItemsController {

    private final CodeCoolerItemsService codeCoolerItemsService;

    public CodeCoolerItemsController(CodeCoolerItemsService codeCoolerItemsService) {
        this.codeCoolerItemsService = codeCoolerItemsService;
    }

    @GetMapping("/my_items")
    public String getStudentsList(Model model, @SessionAttribute("loggedUser") User loggedUser){
        model.addAttribute("my_items", codeCoolerItemsService.getByCodeCoolerID(loggedUser.getUserId()));
        return "store/my_items_list";
    }

    @GetMapping("/use_item/{id}")
    public String useItem(@PathVariable("id") long id, Model model, @SessionAttribute("loggedUser") User loggedUser) {
        codeCoolerItemsService.markUsedItem(id);
        model.addAttribute("my_items", codeCoolerItemsService.getByCodeCoolerID(loggedUser.getUserId()));
        return "redirect:/my_items";
    }
}
