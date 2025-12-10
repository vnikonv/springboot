package com.veremeichik.spring.services;

import com.veremeichik.spring.repositories.TaskRepository;
import com.veremeichik.spring.entities.Task;
import com.veremeichik.spring.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.veremeichik.spring.mappers.UserMapper;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserMapper userMapper;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<TaskDTO> getTaskDTO() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(userMapper::taskToTaskDTO)
                .toList();
    }
}
