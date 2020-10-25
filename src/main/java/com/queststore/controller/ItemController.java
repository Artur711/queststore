package com.queststore.controller;

import com.queststore.model.CodeCooler;
import com.queststore.model.Item;
import com.queststore.model.User;
import com.queststore.service.CodeCoolerService;
import com.queststore.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
        model.addAttribute("items", itemService.getUniqueItems(loggedUser.getUserId()));
        return "store/items_store";
    }

    @GetMapping("/my_items")
    public String getMyItemsList(@SessionAttribute("loggedUser") User loggedUser, Model model) {
        Long id = loggedUser.getUserId();
        List<Item> listItems = itemService.getCodecoolerItems(id);
        model.addAttribute("codecoolerItems", listItems);
        return "inventory/my_items_list";
    }

    @GetMapping("/use_item/{id}")
    public String useItem(@PathVariable("id") long id, Model model, @SessionAttribute("loggedUser") User loggedUser) {
        itemService.delete(id);
        model.addAttribute("codecoolerItems", itemService.getCodecoolerItems(loggedUser.getUserId()));
        return "redirect:/welcome_page";
    }

    @GetMapping("/item_list")
    public String getItemsList(Model model){
        model.addAttribute("items", itemService.getAll());
        return "inventory/item_list";
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

    @GetMapping("/edit/{id}")
    public String editItem(@PathVariable("id") long id, Model model) {
        Item item = itemService.getById(id);
        model.addAttribute("item", item);
        return "inventory/edit_item";
    }

    @GetMapping("/delete/{id}")
    public String removeItem(@PathVariable("id") long id, Model model) {
        itemService.delete(id);
        model.addAttribute("items", itemService.getAll());
        return "redirect:/item_list";
    }

    @GetMapping("/add_new_item")
    public String addNewItem(Model model, Item item){
        model.addAttribute("item", item);
        return "store/add_new_item";
    }

    @PostMapping("/add_new_item")
    public String addItem(Model model, @Valid Item item){

        item.setImg("/../photo/img/logo-menu/logo-menu5.jpg");
        itemService.save(item);
        model.addAttribute("items", itemService.getAll());
        return "redirect:/item_list";
    }

    @PostMapping("/update/{id}")
    public String updateItem(@PathVariable("id") long id, @Valid Item item, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "inventory/edit_item";
        }
        item.setItemId(id);
        itemService.save(item);

        return "redirect:/item_list";
    }
}
