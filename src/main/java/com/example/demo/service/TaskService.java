package com.example.demo.service;



import com.example.demo.task.TaskEntity;


import java.util.List;


public interface TaskService {
    List<TaskEntity> listAll();
    TaskEntity findId(int id);
    void save(TaskEntity entity);
}
