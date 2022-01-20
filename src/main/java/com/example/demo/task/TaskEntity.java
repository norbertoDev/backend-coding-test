package com.example.demo.task;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "task")
public class TaskEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private boolean completed;

    @Column(name = "creationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar creationDate;

    @Enumerated(EnumType.ORDINAL)
    private TaskPriority priority;

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

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public Calendar getCreationDate() {return creationDate;}

    public void setCreationDate(Calendar creationDate) {this.creationDate = creationDate;}
}
