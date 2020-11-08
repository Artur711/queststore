package com.queststore.controller;

import com.queststore.service.CodeCoolerService;
import com.queststore.service.ItemService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
public class ItemControllerIntegrationTestConfiguration {
    @Bean
    public ItemService itemService() {
        return Mockito.mock(ItemService.class);
    }

    @Bean
    public CodeCoolerService codeCoolerService() {
        return Mockito.mock(CodeCoolerService.class);
    }

    @Bean
    public ItemController itemController() {
        return new ItemController(itemService(), codeCoolerService());
    }

}
