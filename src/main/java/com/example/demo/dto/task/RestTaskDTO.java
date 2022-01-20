package com.example.demo.dto.task;


import com.example.demo.task.TaskPriority;
import lombok.Data;

import java.util.Calendar;
import java.util.Date;

@Data
public class RestTaskDTO {


    private int id;
    private String description;
    private boolean completed;
    private TaskPriority priority;



    private Calendar creationDate;

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
