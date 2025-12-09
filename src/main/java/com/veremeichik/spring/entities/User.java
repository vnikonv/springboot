package com.veremeichik.spring.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Users")
public class User {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private String password;

    @Setter
    @Getter
    private String avatar;

    @Setter
    @Getter
    private Boolean completed;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Task> tasks = new ArrayList<>();

    protected User () {}

    public User(Long id, String name, String password, String avatar, Boolean completed, List<Task> tasks) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.avatar = avatar;
        this.completed = completed;
        this.tasks = tasks;
    }

    public String getTasks() {
        for (Task task : tasks) {
            return task.getTask();
        }
        return null;
    }
}
