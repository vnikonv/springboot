package com.veremeichik.spring.dto;

import lombok.Data;
import java.util.List;

@Data
public class UserWithTaskDTO {
    private Long id;
    private String name;
    private String avatar;
    private Boolean status;
    private List<TaskDTO> task_list;
}
