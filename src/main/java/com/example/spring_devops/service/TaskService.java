package com.example.spring_devops.service;

import com.example.spring_devops.model.Task;

import java.util.List;


public interface TaskService {

    Task createTask( Task newTask);
    List<Task> getAllTasks();
   // Task getTaskById(Long id);
   void deleteTask( Long id);
   // Task updateTask(Long id , Task updatedTask);
}
