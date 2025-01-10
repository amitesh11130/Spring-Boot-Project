package com.springbootapi.services;

import com.springbootapi.entity.User;
import com.springbootapi.execption.UserNotFoundException;
import com.springbootapi.repository.UserDAO;
import com.springbootapi.request.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;


    public User saveUser(UserDTO userDTO) {
        return userDAO.save(userDTO);
    }

    public List<User> saveAllUser(List<UserDTO> userList) {
        return userDAO.saveAll(userList);
    }

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }


    public User getUserById(int id) throws UserNotFoundException {
        boolean user = userDAO.existById(id);
        if (user)
            return userDAO.findById(id);
        throw new UserNotFoundException("User not found with given id !! " + id);
    }

    public User updateUser(int id, UserDTO userDTO) throws UserNotFoundException {
        boolean user = userDAO.existById(id);
        if (user)
            return userDAO.updateUser(id, userDTO);
        throw new UserNotFoundException("No users found to update with given id !! " + id);
    }

    public User updateUserName(int id, String name) throws UserNotFoundException {
        boolean user = userDAO.existById(id);
        if (user)
            return userDAO.updateUserName(id, name);
        throw new UserNotFoundException("No users found to update name with given id !! " + id);
    }

    public void deleteUserById(int id) throws UserNotFoundException {
        boolean user = userDAO.existById(id);
        if (user) {
            userDAO.deleteUserById(id);
            return;
        }
        throw new UserNotFoundException("No users found to delete with given id !! " + id);
    }

    public boolean existById(int id) {
        return userDAO.existById(id);
    }
}
