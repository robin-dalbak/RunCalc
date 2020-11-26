package com.app.runcalc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RunCalcApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MeasurementRepository measurementRepository;

    @Autowired
    UserService userService;


    @Test
    void contextLoads() {
    }

    @Test
    void shouldFindNumberOfUsers() {
        assertEquals(6, userRepository.count());
    }

    @Test
    void findUserWithId() {
        User user = userRepository.findById(6).get();

        assertEquals("Kristine", user.getFirstName());
        assertEquals("Jensen", user.getLastName());
        assertEquals("123456", user.getPassword());
        assertEquals("Kristine123@gmail.com",user.getEmail());

    }

    @Test
    void findUserWithEmail() {
        User user = userRepository.findByEmail("Abdi123@gmail.com");

        assertEquals("123456", user.getPassword());

    }

    @Test
    void findBMI() {
        Measurement measurement = measurementRepository.findById(1).get();

        assertEquals(23, measurement.getBmi());
    }

//    @Test
//    void addUser() {
//        User user = userService.addUser("");
//    }


//    @Test
//    void findUserByAge() {
//        Measurement measurement = (Measurement) repository.findById(1).get();
//
//        assertEquals(18, measurement.getAge());
//    }
//

}
