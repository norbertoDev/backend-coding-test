package com.example.demo.service.impl;


import com.example.demo.dto.task.RestTaskDTO;
import com.example.demo.interfaces.TaskRepository;
import com.example.demo.service.TaskService;
import com.example.demo.task.TaskEntity;
import com.example.demo.task.TaskPriority;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

    private TaskRepository taskRepository;
    ModelMapper modelMapper = new ModelMapper();

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<RestTaskDTO> listAll() {

        List<RestTaskDTO> result = new ArrayList<RestTaskDTO>();
        taskRepository.findAll().forEach(
                index -> result.add(modelMapper.map(index, RestTaskDTO.class)));
        return result;
    }

    @Override
    public RestTaskDTO findId(int id) {
        return modelMapper.map(taskRepository.findById(id).get(), RestTaskDTO.class);
    }

    @Override
    public void save(RestTaskDTO dto) {
        TaskEntity entity = modelMapper.map(dto,TaskEntity.class);
        taskRepository.save(entity);
    }

    @Override
    public RestTaskDTO delete(int id) {
        TaskEntity entity = taskRepository.findById(id).get();
        taskRepository.delete(entity);
        return modelMapper.map(entity, RestTaskDTO.class);
    }

    @Override
    public List<RestTaskDTO> orderByCreation() {
        List<RestTaskDTO> result = new ArrayList<RestTaskDTO>();
        taskRepository.orderBy(Sort.by("creationDate")).forEach(
                index -> result.add(modelMapper.map(index, RestTaskDTO.class)));
        return result;
    }

    @Override
    public List<RestTaskDTO> orderByPriority() {
        List<RestTaskDTO> result = new ArrayList<RestTaskDTO>();
        taskRepository.orderBy(Sort.by("priority")).forEach(
                index -> result.add(modelMapper.map(index, RestTaskDTO.class)));
        return result;
    }

    @Override
    public List<RestTaskDTO> filterByPriority(TaskPriority priority) {
        List<RestTaskDTO> result = new ArrayList<RestTaskDTO>();
        taskRepository.filterByPriority(priority).forEach(
                index -> result.add(modelMapper.map(index, RestTaskDTO.class)));
        return result;
    }

}
