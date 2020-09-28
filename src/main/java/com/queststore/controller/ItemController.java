package com.queststore.controller;

import com.queststore.model.Codecoolers;
import com.queststore.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class ItemController {

    private ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping("/items_menu")
    public String chooseItemType() {
        return "items_menu";
    }

    @GetMapping("/items_store")
    public String getTeamItems(Model model) {
        model.addAttribute("items", service.getAll());
        return "items_store";
    }

   /* @PostMapping("team_items/buy/{id}")
    public String buyTeamItem(@PathVariable("id") long id, @Valid Codecoolers codecooler, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "update_student";
        }
        return "redirect:/team_items";
    }*/
}
