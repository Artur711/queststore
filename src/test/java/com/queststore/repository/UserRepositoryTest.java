package com.queststore.repository;

import com.queststore.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserRepositoryTest {

//    private TestEntityManager entityManager;

//    private UserRepository userRepository;
//
//    public UserRepositoryTest(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Test
    public void findAll() {
    }

    @Test
    public void findUserByLastNameAndPassword() {
        User user = getUser();
//        User savedUser = userRepository.save(user);
//        User savedUsed = entityManager.persist(user);
//        User userFromDB =  userRepository.findUserByLastNameAndPassword(user.getLastName(), user.getPassword());
        assertEquals("1234n", user.getPassword());
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
}