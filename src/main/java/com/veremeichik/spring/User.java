package com.veremeichik.spring;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Task> tasks = new ArrayList<>();

    protected User () {}

    public User(Long id, String name, String password, List<Task> tasks) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.tasks = tasks;
    }

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public String getPassword() { return this.password; }
    public void setPassword(String password) { this.password = password; }
    public List<Task> getTasks() { return this.tasks; }
    public void setTasks(List<Task> tasks) { this.tasks = tasks; }
}
