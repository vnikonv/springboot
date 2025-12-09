package com.veremeichik.spring.controllers;

import com.veremeichik.spring.*;
import com.veremeichik.spring.dto.UserWithTaskDTO;
import com.veremeichik.spring.entities.Task;
import com.veremeichik.spring.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("bydto/{user_id}")
    public UserWithTaskDTO getUserWithTask(@PathVariable long user_id) {
        return userService.getUserWithTask(user_id);
    }

    @GetMapping("allusers_with_tasks")
    public List<UserWithTaskDTO> getAllUsersWithTasks() {
        return userService.getAllUsersWithTasks();
    }
}
