package com.example.demo.service.impl;


import com.example.demo.interfaces.TaskRepository;
import com.example.demo.service.TaskService;
import com.example.demo.task.TaskEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<TaskEntity> listAll() {
        return taskRepository.findAll();
    }

    @Override
    public TaskEntity findId(int id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public void save(TaskEntity entity) {
        taskRepository.save(entity);
    }

    @Override
    public void delete(TaskEntity entity) {
        taskRepository.delete(entity);
    }

}
