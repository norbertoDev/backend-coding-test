package com.example.demo.dto.task;


import com.example.demo.task.TaskPriority;
import lombok.Data;

@Data
public class CreateTaskDTO {
    private String description;
    private boolean completed;
    private TaskPriority priority;

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


}
