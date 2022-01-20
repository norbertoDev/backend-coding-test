package com.example.demo.task;

import org.springframework.scheduling.config.Task;

import javax.persistence.*;

@Entity
@Table(name = "subtask")
public class SubTaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "idtask")
    private TaskEntity task;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
