package com.example.spring_devops.controller;


import com.example.spring_devops.model.Task;
import com.example.spring_devops.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("{id}")
    public Optional<Task>getTaskById(@PathVariable("id") long id){
        return taskService.getTaskById(id);
    }


    @DeleteMapping("/{id}")
    void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
