package com.veremeichik.spring.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Tasks")
public class Task {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Tasks;

    @Getter
    @Setter
    private String description;

    @Setter
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

    public String getTask() {
        return this.Tasks;
    }

}
