package com.veremeichik.spring;

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

@Entity
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
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
    public String getTasks() {
        for (Task task : tasks) {
            return task.getTask();
        }
        return null;
    }
    public void setTasks(List<Task> tasks) { this.tasks = tasks; }
}
