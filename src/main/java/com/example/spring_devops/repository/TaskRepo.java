package com.example.spring_devops.repository;


import com.example.spring_devops.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo  extends JpaRepository<Task,Long> {

  Task findById(long id);


}
