package com.queststore.controller;

import com.queststore.model.Item;
import com.queststore.service.CodeCoolerService;
import com.queststore.service.ItemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ItemControllerIntegrationTestConfiguration.class})
@WebAppConfiguration
public class ItemControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private CodeCoolerService codeCoolerService;

    @Autowired
    private ItemService itemService;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void should_return_all_items() throws Exception {
        //given
        List<Item> itemsList = createItemsList();
        when(itemService.getAll()).thenReturn(itemsList);
        //when
        //then
        mockMvc.perform(get("/item_list"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("items", hasSize(6)))
                .andExpect(model().attribute("items", hasItem(allOf(
                        hasProperty("name", is("name1")),
                        hasProperty("description", is("description1")),
                        hasProperty("price", is(10))
                ))))
        .andExpect(model().attribute("items", hasItem(itemsList.get(2)) ))
        ;
    }

    @Test
    public void should_add_the_item() throws Exception {
       //given
       Item item = createItemsList().get(0);
       //when then
        mockMvc.perform(post("/add_new_item")
                .param("name", item.getName())
                .param("description", item.getDescription())
                .param("price", "10")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(redirectedUrl("/item_list"));
    }

    private List<Item> createItemsList() {
        Item item = new Item("name1", "description1", 10);
        Item item2 = new Item("name2", "description2", 1045);
        Item item3 = new Item("name3", "description3", 105);
        Item item4 = new Item("name4", "description4", 105);
        Item item5 = new Item("name5", "description5", 103);
        Item item6 = new Item("name6", "description6", 104);
        return Arrays.asList(item, item2, item3, item4, item5, item6);
    }
}

