package com.queststore.repository;

import com.queststore.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void should_find_all() {
        //given:
        int listSize = 6;

        //when:
        List<User> userList = (List<User>) userRepository.findAll();

        //then:
        assertAll(() -> assertEquals(userList.size(), listSize),
                () -> assertEquals(getSecondUser(), userList.get(1)),
                () -> assertEquals(getLastUser(), userList.get(listSize - 1)));
    }

    @Test
    public void should_find_user_by_last_name_and_password() {
        // given:
        User user = getUser();

        //when:
        userRepository.save(user);
        User maybeSavedUser = userRepository.findUserByLastNameAndPassword(user.getLastName(), user.getPassword());

        //then:
        assertEquals(user, maybeSavedUser);
    }

    private User getUser() {
        User user = new User();
        user.setFirstName("Damian");
        user.setLastName("Nowak");
        user.setEmail("nowak@gmail.com");
        user.setPassword("1234n");
        user.setPhoneNumber(1554557);
        user.setUserType(2);
        return user;
    }

    private User getSecondUser() {
        User user = new User();
        user.setUserId(2);
        user.setFirstName("MARIUSZ");
        user.setLastName("KALAMAGA");
        user.setEmail("kala@gmial.com");
        user.setPassword("1234k");
        user.setPhoneNumber(123456788);
        user.setPhotoUrl("");
        user.setUserType(1);
        return user;
    }

    private User getLastUser() {
        User user = new User();
        user.setUserId(6);
        user.setFirstName("MARIUSZ");
        user.setLastName("WACH");
        user.setEmail("wachu@gmial.com");
        user.setPassword("1234w");
        user.setPhoneNumber(123456784);
        user.setPhotoUrl("");
        user.setUserType(3);
        return user;
    }
}