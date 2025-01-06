package com.example.spring_devops.controller;


import com.example.spring_devops.model.Task;
import com.example.spring_devops.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/task")
public class TaskController {
    private final TaskService taskService ;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return new ResponseEntity<>(taskService.createTask(task), HttpStatus.CREATED);
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
