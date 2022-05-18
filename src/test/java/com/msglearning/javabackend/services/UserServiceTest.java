package com.msglearning.javabackend.services;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserServiceTest {

    @Test
    void isValidEmailAddress_invalid() {
        UserService userService = new UserService();
        boolean valid = userService.isValidEmailAddress("kjjk");
        assertThat(valid).isFalse();
    }
    @Test
    void isValidEmailAddress_valid() {
        UserService userService = new UserService();
        boolean valid = userService.isValidEmailAddress("something@gmail.com");
        assertThat(valid).isTrue();
    }

    @Test
    void isValidPhoneNumber_invalid() {
        UserService userService = new UserService();
        boolean valid = userService.isValidRomanianPhoneNumber("+49213-564-864");
        assertThat(valid).isFalse();
    }

    @Test
    void isValidPhoneNumber_valid() {
        UserService userService = new UserService();
        boolean valid = userService.isValidRomanianPhoneNumber("+40213-564-864");
        assertThat(valid).isTrue();
    }
}