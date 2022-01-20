package com.example.demo.interfaces;

import com.example.demo.task.TaskEntity;
import com.example.demo.task.TaskPriority;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

    @Query(value = "SELECT t from TaskEntity t")
    List<TaskEntity> orderBy(Sort creationDate);

    @Query(value = "SELECT t from TaskEntity t where t.priority =  :priority")
    List<TaskEntity> filterByPriority(@Param("priority") TaskPriority priority);
}
