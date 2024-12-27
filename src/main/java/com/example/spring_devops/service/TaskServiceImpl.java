package com.example.spring_devops.service;


import com.example.spring_devops.model.Task;
import com.example.spring_devops.repository.TaskRepo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskServiceImpl  implements TaskService{

    private final TaskRepo taskRepo ;

    public  TaskServiceImpl(TaskRepo taskRepo){

        this.taskRepo= taskRepo;
    }

    @Override
    public Task createTask (Task newTask){
        return taskRepo.save(newTask);
    }

    @Override
    public List<Task>getAllTasks(){
        return taskRepo.findAll();
    }


    @Override
    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }
}