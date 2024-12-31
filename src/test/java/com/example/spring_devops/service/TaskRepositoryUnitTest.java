package com.example.spring_devops.service;

import com.example.spring_devops.model.Task;
import com.example.spring_devops.repository.TaskRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

    @DataJpaTest
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    public class TaskRepositoryUnitTest  {

        @Autowired
        private TaskRepo taskRepo;

        @Test
        @DisplayName("Test 1:Save Task Test")
        @Order(1)
        @Rollback(value = false)
        public void saveTaskTest(){

            //Action
            Task task = Task.builder()
                    .description("this is the test for the task ")
                    .name("test task")
                    .deadline(LocalDate.parse("2024-05-02"))
                    .build();

            taskRepo.save(task);

            //Verify
            System.out.println(task);
            Assertions.assertThat(task.getId()).isGreaterThan(0);
        }

        @Test
        @Order(2)
        public void getTaskTest(){

            //Action
            Task task = taskRepo.findById(1L).get();
            //Verify
            System.out.println(task);
            Assertions.assertThat(task.getId()).isEqualTo(1L);
        }

        @Test
        @Order(3)
        public void getListOfTasksTest(){
            //Action
            List<Task> tasks = taskRepo.findAll();
            //Verify
            System.out.println(tasks);
            Assertions.assertThat(tasks.size()).isGreaterThan(0);

        }


        @Test
        @Order(4)
        @Rollback(value = false)
        public void deleteTaskTest(){
            //Action
            taskRepo.deleteById(1L);
            Optional<Task> taskOptional = taskRepo.findById(1L);

            //Verify
            Assertions.assertThat(taskOptional).isEmpty();
        }

    }

