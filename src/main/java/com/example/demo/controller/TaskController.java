package com.example.demo.controller;

import com.example.demo.service.TaskService;

import com.example.demo.task.TaskEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class TaskController {

    @Autowired
    private TaskService service;

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @GetMapping("/tasks")
    public List<TaskEntity> list(){
        return service.listAll();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> findId(@PathVariable int id){
        try{
            TaskEntity entity = service.findId(id);
            return new ResponseEntity<TaskEntity>(entity,HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<TaskEntity>(HttpStatus.NOT_FOUND);
        }
    }
}
