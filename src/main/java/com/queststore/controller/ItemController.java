package com.queststore.controller;

import com.queststore.model.Codecoolers;
import com.queststore.model.Item;
import com.queststore.model.User;
import com.queststore.service.CodeCoolerService;
import com.queststore.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.validation.Valid;


@Controller
public class ItemController {

    private final CodeCoolerService codeService;
    private final ItemService itemService;

    public ItemController(ItemService itemService, CodeCoolerService codeService) {

        this.itemService = itemService;
        this.codeService = codeService;
    }

    @GetMapping("/items_menu")
    public String chooseItemType() {
        return "store/items_menu";
    }


    @GetMapping("/items_store/{type}")
    public String getQuestList(@PathVariable("type") int type,@SessionAttribute("loggedUser") User loggedUser, Model model){
        model.addAttribute("coins", codeService.getByUserID(loggedUser.getUserId()).getCodecool_coins());
        model.addAttribute("items", itemService.getAll());
        return "store/items_store";
    }

    @GetMapping("/buy")
    public String buyItem(Model model, @SessionAttribute("loggedUser") User loggedUser) {
        model.addAttribute("id", codeService.getByUserID(loggedUser.getUserId()));
        System.out.println();
        return "store/update_student";
    }

   /* @PostMapping("team_items/buy/{id}")
    public String buyTeamItem(@PathVariable("id") long id, @Valid Codecoolers codecooler, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "update_student";
        }
        return "redirect:/team_items";
    }*/
}
