package com.app.runcalc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RunCalcApplicationTests {

    @Autowired
    UserRepository repository;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldFindNumberOfUsers() {
        assertEquals(6, repository.count());
    }

    @Test
    void findUserWithId() {
        User user = repository.findById(6).get();

        assertEquals("Kristine", user.getFirstName());
        assertEquals("Jensen", user.getLastName());
        assertEquals("123456", user.getPassword());
        assertEquals("Kristine123@gmail.com",user.getEmail());
    }

}
