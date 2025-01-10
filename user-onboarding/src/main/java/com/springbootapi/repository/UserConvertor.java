package com.springbootapi.repository;

import com.springbootapi.entity.User;
import com.springbootapi.request.UserDTO;

public class UserConvertor {

    public static User convert(UserDTO userDTO) {
//        Address address = Address.builder()
//                .city(userDTO.getAddressDTO().getCity())
//                .state(userDTO.getAddressDTO().getState())
//                .pincode(userDTO.getAddressDTO().getPincode())
//                .build();

        User user = User.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .contact(userDTO.getContact())
                .dateOfBirth(userDTO.getDateOfBirth())
               // .address(address)
                .build();

        return user;
    }
}
