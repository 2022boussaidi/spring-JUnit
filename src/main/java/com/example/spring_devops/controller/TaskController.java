package com.example.spring_devops.controller;


import com.example.spring_devops.model.Task;
import com.example.spring_devops.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("task")
public class TaskController {
    private final TaskService taskService ;

    @PostMapping
    Task newTask(@RequestBody Task newTask){
        return taskService.createTask(newTask);
    }
    
    @GetMapping
    List<Task> getAllTasks() {

        return taskService.getAllTasks();
    }



    @DeleteMapping("/{id}")
    void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
