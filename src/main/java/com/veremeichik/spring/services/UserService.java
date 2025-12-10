package com.veremeichik.spring.services;

import com.veremeichik.spring.repositories.UserRepository;
import com.veremeichik.spring.dto.UserWithTaskDTO;
import com.veremeichik.spring.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.veremeichik.spring.mappers.UserMapper;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public UserWithTaskDTO getUserWithTask(long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User with id " + userId + " not found"));
        return userMapper.userToUserWithTaskDTO(user);
    }

    public List<UserWithTaskDTO> getAllUsersWithTasks() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::userToUserWithTaskDTO)
                .toList();
    }

    public UserService(UserRepository userRepository) { this.userRepository = userRepository; }
}
