package com.example.demo.service;



import com.example.demo.dto.task.RestTaskDTO;
import com.example.demo.task.TaskPriority;


import java.util.List;


public interface TaskService {
    List<RestTaskDTO> listAll();
    RestTaskDTO findId(int id);
    void save(RestTaskDTO entity);
    RestTaskDTO delete(int id);
    List<RestTaskDTO> orderByCreation();
    List<RestTaskDTO> orderByPriority();
    List<RestTaskDTO> filterByPriority(TaskPriority priority);
}
