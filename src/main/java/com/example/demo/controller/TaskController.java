package com.example.demo.controller;

import com.example.demo.dto.task.CreateTaskDTO;
import com.example.demo.dto.task.UpdateTaskDTO;
import com.example.demo.service.TaskService;

import com.example.demo.task.TaskEntity;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
public class TaskController {

    @Autowired
    private TaskService service;

    ModelMapper modelMapper = new ModelMapper();

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    /**
     * Method data return the list of all task in DB
     *
     * @return
     */
    @GetMapping("/tasks")
    public List<TaskEntity> list(){
        return service.listAll();
    }

    /**
     * method that searc a task through an id passed by parameters
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> findId(@PathVariable int id){
        try{
            TaskEntity entity = service.findId(id);
            return new ResponseEntity<TaskEntity>(entity,HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<TaskEntity>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Method Post to add news task in DB
     * @param dto
     */
    @PostMapping(value = "/add")
    public void add(@RequestBody CreateTaskDTO dto){
        /*
            Aqui generamos el la conver de DTO to Entity
         */
        TaskEntity entity = modelMapper.map(dto, TaskEntity.class);
        service.save(entity);
    }

    /**
     * endpoint rest to update de Task entity
     * @param dto
     * @return
     */
    @PutMapping(value = "/update")
    public ResponseEntity<TaskEntity> updateTask(@RequestBody UpdateTaskDTO dto){
        try{
            TaskEntity entity = service.findId(dto.getId());
            if(entity != null) {
                entity.setDescription(dto.getDescription() != null ? dto.getDescription() : entity.getDescription());
                entity.setPriority(dto.getPriority() != null ? dto.getPriority() : entity.getPriority());
                entity.setCompleted(dto.isCompleted());
                service.save(entity);
            }
            return new ResponseEntity<TaskEntity>(entity,HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<TaskEntity>(HttpStatus.NOT_FOUND);
        }
    }
}
