package com.queststore.controller;

import com.queststore.model.Codecoolers;
import com.queststore.model.Item;
import com.queststore.model.User;
import com.queststore.service.CodeCoolerService;
import com.queststore.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String getQuestList(@PathVariable("type") int type, @SessionAttribute("loggedUser") User loggedUser, Model model) {
        model.addAttribute("coins", codeService.getByUserID(loggedUser.getUserId()).getCodecool_coins());
        model.addAttribute("items", itemService.getAll());
        return "store/items_store";
    }


    @PostMapping("/buy")
    public String buyItem(Model model, @SessionAttribute("loggedUser") User loggedUser, @RequestParam(value = "itemId") long itemId) {

        model.addAttribute("id", codeService.getByUserID(loggedUser.getUserId()));
        int studentCoins = codeService.getByID(loggedUser.getUserId()).getCodecool_coins();
        int itemPrice = itemService.getById(itemId).getPrice();
        int loggedUserId = (int) loggedUser.getUserId();

        codeService.updateCodecoolerItems(loggedUserId, (studentCoins - itemPrice), (int) itemId);

        return "redirect:/items_menu";
    }
}
