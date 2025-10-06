package com.veremeichik.spring;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Tasks;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    protected Task () {}

    public Task(Long id, String Tasks, String description, User user) {
        this.id = id;
        this.Tasks = Tasks;
        this.description = description;
        this.user = user;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return this.Tasks;
    }

    public void setTask(String Tasks) {
        this.Tasks = Tasks;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser() {
        return this.user.getName();
    }

    public void setUser(User user) {
        this.user = user;
    }
}
