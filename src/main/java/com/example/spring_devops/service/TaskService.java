package com.example.spring_devops.service;

import com.example.spring_devops.model.Task;

import java.util.List;
import java.util.Optional;


public interface TaskService {

    Task createTask( Task newTask);
    List<Task> getAllTasks();

    Optional<Task> getTaskById(long id);

    void deleteTask(Long id);
   // Task updateTask(Long id , Task updatedTask);
}
