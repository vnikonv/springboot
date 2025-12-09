package com.veremeichik.spring.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.veremeichik.spring.entities.User;
import com.veremeichik.spring.entities.Task;
import com.veremeichik.spring.dto.TaskDTO;
import com.veremeichik.spring.dto.UserWithTaskDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {
    //@Mapping(target = "task_list", source = "tasks")
    @Mapping(target = "status", source = "completed")
    UserWithTaskDTO userToUserWithTaskDTO(User user);

    @Mapping(target = "tasks", source = "task")
    @Mapping(target = "description", source = "description")
    TaskDTO taskToTaskDTO(Task task);
}
