package com.queststore.controller;

import com.queststore.model.User;
import com.queststore.service.CodeCoolerService;
import com.queststore.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("coins", codeService.getCodeCoolerById(loggedUser.getUserId()).getCodeCoolCoins());
        model.addAttribute("items", itemService.getAll());
        return "store/items_store";
    }


    @PostMapping("/buy")
    public String buyItem(Model model, @SessionAttribute("loggedUser") User loggedUser, @RequestParam(value = "itemId") Long itemId) {

        model.addAttribute("id", codeService.getCodeCoolerById(loggedUser.getUserId()));

        int studentCoins = codeService.getCodeCoolerById(loggedUser.getUserId()).getCodeCoolCoins();
        int itemPrice = itemService.getById(itemId).getPrice();
        Long loggedUserId = loggedUser.getUserId();

        itemService.buyItem(itemId, loggedUserId);
        codeService.updateCoinsBalance((studentCoins - itemPrice), loggedUserId);

        return "redirect:/items_menu";
    }
}
