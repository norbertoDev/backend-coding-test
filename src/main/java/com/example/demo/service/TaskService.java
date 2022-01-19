package com.example.demo.service;


import com.example.demo.task.TaskEntity;


import java.util.List;
import java.util.Optional;


public interface TaskService {
    List<TaskEntity> listAll();
    TaskEntity findId(int id);
}
