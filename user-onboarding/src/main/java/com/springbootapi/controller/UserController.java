package com.springbootapi.controller;

import com.springbootapi.entity.User;
import com.springbootapi.execption.UserNotFoundException;
import com.springbootapi.request.UserDTO;
import com.springbootapi.services.UserService;
import com.springbootapi.response.ResponseDTO;
import com.springbootapi.response.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Validated
@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/saveUser")
    public ResponseEntity<ResponseDTO> saveUser(@Valid @RequestBody UserDTO userDTO) {
        User saveUser = userService.saveUser(userDTO);
        return ResponseUtil.created("User created successfully", saveUser);
    }

    @PostMapping(value = "/saveAllUsers")
    public ResponseEntity<ResponseDTO> saveAllUser(@RequestBody @Valid List<UserDTO> userDTO) {
        List<User> saveUser = userService.saveAllUser(userDTO);
        return ResponseUtil.created("User created successfully", saveUser);
    }

    @GetMapping(value = "/getAllUsers")
    public ResponseEntity<ResponseDTO> getAllUser() {
        List<User> users = userService.getAllUsers();

        if (ObjectUtils.isEmpty(users)) {
            return ResponseUtil.notFound("No users found");
        }
        return ResponseUtil.success("Users retrieved successfully", users);
    }

    @GetMapping(value = "/getUser")
    public ResponseEntity<ResponseDTO> getUserById(@RequestHeader("id") int id) throws UserNotFoundException {

            User user = userService.getUserById(id);
            return ResponseUtil.success("User retrieved successfully", user);

    }

    @PutMapping(value = "/updateUser/{id}")
    public ResponseEntity<ResponseDTO> updateUser(@PathVariable int id,
                                                  @Valid @RequestBody UserDTO userDTO) throws UserNotFoundException {

            User updatedUser = userService.updateUser(id, userDTO);
            return ResponseUtil.updated("User updated successfully", updatedUser);

    }

    @PutMapping(value = "/updateUser/{id}/{name}")
    public ResponseEntity<ResponseDTO> updateUserName(@PathVariable int id,
                                                      @PathVariable String name) throws UserNotFoundException {
            User updatedUser = userService.updateUserName(id, name);
            return ResponseUtil.updated("User name updated successfully", updatedUser);

    }

    @DeleteMapping(value = "/deleteUser")
    public ResponseEntity<ResponseDTO> deleteUser(@RequestParam("id") int id) throws UserNotFoundException {

            userService.deleteUserById(id);
            return ResponseUtil.deleted("User deleted successfully", true);

    }
}