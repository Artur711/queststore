package com.queststore.configuration;

import com.queststore.filter.AuthorizationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuestStoreConfiguration {

    @Bean
    public FilterRegistrationBean<AuthorizationFilter> authorizationFilter() {
        FilterRegistrationBean<AuthorizationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AuthorizationFilter());
        registrationBean.addUrlPatterns("/all_classes/*",
                "/admins_list/*",
                "/mentors_list/*",
                "/student_list/*",
                "/experiences/*",
                "/menu", "/welcome_page",
                "/profile/*",
                "/codecool");

        return registrationBean;
    }
}
