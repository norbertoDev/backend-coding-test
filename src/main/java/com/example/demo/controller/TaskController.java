package com.example.demo.controller;

import com.example.demo.service.TaskService;

import com.example.demo.task.TaskEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService service;

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @GetMapping("/tasks")
    public List<TaskEntity> list(){
        return service.listAll();
    }
}
