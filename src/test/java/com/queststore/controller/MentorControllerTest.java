//package com.queststore.controller;
//
//import com.queststore.model.User;
//import com.queststore.service.UserService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.hamcrest.Matchers.*;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {MentorControllerIntegrationTestConfiguration.class})
//@WebAppConfiguration
//public class MentorControllerTest {
//
//    @Autowired
//    private WebApplicationContext webApplicationContext;
//
//    @Autowired
//    private UserService userService;
//
//    private MockMvc mockMvc;
//
//    @Before
//    public void setUp() {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//    }
//
//    @Test
//    public void should_return_all_mentors_list() throws Exception {
//        //given:
//        List<User> userList = createAllMentors();
//        when(userService.getAllMentors()).thenReturn(userList);
//
//        //when, then:
//        mockMvc.perform(get("/mentors_list"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("mentor/mentors_list"))
//                .andExpect(model().attribute("mentors",hasSize(2)))
//                .andExpect(model().attribute("mentors", hasItem(
//                        allOf(
//                                hasProperty("userId", is(341L)),
//                                hasProperty("firstName", is("Adam")),
//                                hasProperty("lastName", is("Nowak")),
//                                hasProperty("email", is("nowak@gmail.com")),
//                                hasProperty("password", is("nowak1234")),
//                                hasProperty("phoneNumber", is(544587756L)),
//                                hasProperty("userType", is(2))
//                        )
//                )))
//                .andExpect(model().attribute("mentors", hasItem(
//                        allOf(
//                                hasProperty("userId", is(352L)),
//                                hasProperty("firstName", is("Julia")),
//                                hasProperty("lastName", is("Roberts")),
//                                hasProperty("email", is("roberts@gmail.com")),
//                                hasProperty("password", is("julia1234")),
//                                hasProperty("phoneNumber", is(55458772L)),
//                                hasProperty("userType", is(2))
//                        )
//                )));
//    }
//
//    @Test
//    public void should_add_new_mentor() throws Exception {
//        mockMvc.perform(get("/add_mentor"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("mentor/add_mentor"))
//                .andExpect(model().attributeExists("user"))
//                .andExpect(model().attribute("user", allOf(
//                        hasProperty("firstName", is(nullValue())),
//                        hasProperty("lastName", is(nullValue())),
//                        hasProperty("email", is(nullValue())),
//                        hasProperty("password", is(nullValue())),
//                        hasProperty("phoneNumber", is(notNullValue()))
//                )));
//    }
//
//    @Test
//    public void should_add_the_mentor() throws Exception {
//        //given
//        String firstName = "Jams";
//        String lastName = "Bond";
//        String email = "j.bond@secretservice.com";
//        String password = "K9sdT8*Y";
//        Long phoneNumber = 15548955L;
//
//        // when, then:
//        mockMvc.perform(
//                post("/add_mentor")
//                        .param("firstName", firstName)
//                        .param("lastName", lastName)
//                        .param("email", email)
//                        .param("password", password)
//                        .param("phoneNumber", String.valueOf(phoneNumber))
//                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
//                        .andExpect(status().is3xxRedirection())
//                        .andExpect(redirectedUrl("/mentors_list"));
//
//        verify(userService, times(1)).saveMentor(new User(firstName, lastName, email, password, phoneNumber));
//    }
//
//    @Test
//    public void deleteTheMentor() throws Exception {
//        //given:
//        Long id = 1L;
//
//        // when, then:
//        mockMvc.perform(get("/mentor_delete/{id}", id))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/mentors_list"));
//
//        verify(userService, times(1)).deleteUser(id);
//    }
//
//    private List<User> createAllMentors() {
//        User mentor1 = new User();
//        mentor1.setUserId(341L);
//        mentor1.setFirstName("Adam");
//        mentor1.setLastName("Nowak");
//        mentor1.setEmail("nowak@gmail.com");
//        mentor1.setPassword("nowak1234");
//        mentor1.setPhoneNumber(544587756);
//        mentor1.setUserType(2);
//
//        User mentor2 = new User();
//        mentor2.setUserId(352L);
//        mentor2.setFirstName("Julia");
//        mentor2.setLastName("Roberts");
//        mentor2.setEmail("roberts@gmail.com");
//        mentor2.setPassword("julia1234");
//        mentor2.setPhoneNumber(55458772);
//        mentor2.setUserType(2);
//
//        return Arrays.asList(mentor1, mentor2);
//    }
//}