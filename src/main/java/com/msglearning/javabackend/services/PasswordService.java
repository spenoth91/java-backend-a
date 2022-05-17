package com.msglearning.javabackend.services;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
@Service
public class PasswordService {
    @SneakyThrows
    public String hash(String passwordToHash) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt);

        return new String(md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8)));

    }
}
