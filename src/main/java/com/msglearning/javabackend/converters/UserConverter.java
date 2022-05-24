package com.msglearning.javabackend.converters;

import com.msglearning.javabackend.entity.User;
import com.msglearning.javabackend.to.UserTO;

public class UserConverter {

    public static final UserTO convertToTO(User entity) {
        return new UserTO(entity.getId(), entity.getFirstName(),
                entity.getLastName(), entity.getEmail(), entity.getPhone(), entity.getOccupation(), entity.getPassword());

    }
    public static final User convertToEntity(UserTO to) {
        return User.builder()
                .id(to.getId())
                .password(to.getPassword())
                .firstName(to.getFirstName())
                .lastName(to.getLastName())
                .email(to.getEmail())
                .phone(to.getPhone())
                .occupation(to.getOccupation())
                .build();
    }

}
