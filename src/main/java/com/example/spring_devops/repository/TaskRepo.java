package com.example.spring_devops.repository;


import com.example.spring_devops.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepo  extends JpaRepository<Task,Long> {

  Optional<Task> findById(long id);


}
