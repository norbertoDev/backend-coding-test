package com.example.demo.controller;

import com.example.demo.dto.task.RestTaskDTO;
import com.example.demo.dto.task.UpdateTaskDTO;
import com.example.demo.service.TaskService;

import com.example.demo.task.TaskPriority;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public List<RestTaskDTO> list(){
        return service.listAll();
    }

    /**
     * method that searc a task through an id passed by parameters
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<RestTaskDTO> findId(@PathVariable int id){
        try{
            RestTaskDTO entity = service.findId(id);
            return new ResponseEntity<RestTaskDTO>(entity,HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<RestTaskDTO>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * method for order the Task list by the creation Date.
     * @return
     */
    @GetMapping("/orderCreationDate")
    public List<RestTaskDTO> orderCreationDate(){
        return service.orderByCreation();
    }

    @GetMapping("/orderPriority")
    public List<RestTaskDTO> orderPriority(){
        return service.orderByPriority();
    }

    @GetMapping("/filterPriority/{priority}")
    public List<RestTaskDTO> filterPriority(@PathVariable TaskPriority priority){
        return service.filterByPriority(priority);
    }
    /**
     * Method Post to add news task in DB
     * @param dto
     */
    @PostMapping(value = "/add")
    public void add(@RequestBody RestTaskDTO dto){
        /*
            Aqui generamos el la conver de DTO to Entity
         */
        service.save(dto);
    }

    /**
     * endpoint rest to update de Task entity
     * @param dto
     * @return
     */
    @PutMapping(value = "/update")
    public ResponseEntity<RestTaskDTO> updateTask(@RequestBody UpdateTaskDTO dto){
        try{
            RestTaskDTO entity = service.findId(dto.getId());

            entity.setDescription(dto.getDescription() != null ? dto.getDescription() : entity.getDescription());
            entity.setPriority(dto.getPriority() != null ? dto.getPriority() : entity.getPriority());
            entity.setCompleted(dto.isCompleted());
            service.save(entity);

            return new ResponseEntity<RestTaskDTO>(entity,HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<RestTaskDTO>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<RestTaskDTO> deletetask(@PathVariable(value="id") Integer id){
        try{
            RestTaskDTO result = service.delete(id);
            return new ResponseEntity<RestTaskDTO>(result,HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<RestTaskDTO>(HttpStatus.NOT_FOUND);
        }
    }
}
