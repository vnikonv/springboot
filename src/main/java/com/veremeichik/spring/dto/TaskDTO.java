package com.veremeichik.spring.dto;

import com.veremeichik.spring.entities.User;
import lombok.Data;

@Data
public class TaskDTO {
    private Long id;
    private String tasks;
    private String description;
    private String username;
}
