package com.msglearning.javabackend.services;

import com.msglearning.javabackend.converters.UserConverter;
import com.msglearning.javabackend.entity.User;
import com.msglearning.javabackend.exceptionhandling.ValidationException;
import com.msglearning.javabackend.repositories.UserRepository;
import com.msglearning.javabackend.to.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordService passwordService;

    public void save(UserTO userTO) throws Exception {

        List<String> errorMessages = new ArrayList<>();
        if (userTO.getEmail() == null)
            errorMessages.add("The E-mail is missing");
        else if (!isValidEmailAddress(userTO.getEmail()))
            errorMessages.add("Invalid Email");

        if (userTO.getFirstName()==null || userTO.getLastName()==null)
            errorMessages.add("Name is missing");

        if (!isValidRomanianPhoneNumber(userTO.getPhone()))
            errorMessages.add("Phone number is not valid");

        if (userTO.getPassword()==null)
            errorMessages.add("The password is missing");

        if (errorMessages.isEmpty()){
            User user= new User();
            user.setFirstName(userTO.getFirstName());
            user.setLastName(userTO.getLastName());
            user.setEmail(userTO.getEmail());
            user.setPhone(userTO.getPhone());
            user.setPassword(PasswordService.getSaltedHash(userTO.getPassword()));
            user.setOccupation(userTO.getOccupation());

            userRepository.save(user);

        } else
            throw new ValidationException(String.join("\n", errorMessages));

    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public boolean isValidRomanianPhoneNumber(String phone) {
        String ePattern = "^(\\+4|)?(07[0-8]{1}[0-9]{1}|02[0-9]{2}|03[0-9]{2}){1}?(\\s|\\.|\\-)?([0-9]{3}(\\s|\\.|\\-|)){2}$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(phone);
        return m.matches();
    }

    public List<UserTO> findAll() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty())
            return Collections.emptyList();
        else
            return users.stream()
                    .map(UserConverter::convertToTO)
                    .collect(Collectors.toList());
    }

    public List<UserTO> findByName(String token) {
        List<User> users = userRepository.findByName(token);
        if (users.isEmpty())
            return Collections.emptyList();
        else
            return users.stream()
                    .map(UserConverter::convertToTO)
                    .collect(Collectors.toList());
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }


    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<String> getProfileImage(Long userId) {
        return userRepository.findProfileImageById(userId);
    }

    public List<User> getGmailUsers() {
        List<User> allUsers = userRepository.findAll();

        return allUsers.stream()
                .filter(user -> user.getEmail().endsWith("gmail.com"))
                .collect(Collectors.toList());

    }

    public Map<String, List<User>> groupByOccupation() {
        List<User> allUsers = userRepository.findAll();

        return allUsers.stream()
                .collect(Collectors.groupingBy(User::getOccupation));
    }

}