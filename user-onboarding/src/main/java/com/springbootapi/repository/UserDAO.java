package com.springbootapi.repository;

import com.springbootapi.entity.User;
import com.springbootapi.request.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class UserDAO {

    @Autowired
    private UserRepository userRepository;

    public User save(UserDTO userDTO) {
        User user = UserConvertor.convert(userDTO);
        return userRepository.save(user);
    }


    public List<User> saveAll(List<UserDTO> userDTOList) {
        List<User> userList = new ArrayList<>();
        for (UserDTO userDTO : userDTOList) {
            User user = UserConvertor.convert(userDTO);
            userList.add(user);
        }
        return userRepository.saveAll(userList);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(int id) {
        return userRepository.findById(id).get();
    }

    public User updateUserName(int id, String name) {
        User user = userRepository.findById(id).get();
        user.setName(name);
        return userRepository.save(user);

    }

    public User updateUser(int id, UserDTO userDTO) {
        User user = userRepository.findById(id).get();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setDateOfBirth(userDTO.getDateOfBirth());
        user.setContact(userDTO.getContact());
        return userRepository.save(user);
    }

    public void deleteUserById(int id) {
         userRepository.deleteById(id);
    }

    public boolean existById(int id) {
        return userRepository.existsById(id);
    }
}
