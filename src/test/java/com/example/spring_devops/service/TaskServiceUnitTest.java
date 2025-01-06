package com.example.spring_devops.service;

import com.example.spring_devops.model.Task;
import com.example.spring_devops.repository.TaskRepo;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

import org.assertj.core.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TaskServiceUnitTest {
    @Mock
    private TaskRepo taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    private Task task;


    @BeforeEach
    public void setup(){

        task = Task.builder()
                .id(1L)
                .name("task for service test")
                .description("this a task for service test")
                .deadline(LocalDate.parse("2024-05-02"))
                .build();

    }

    @Test
    @Order(1)
    public void saveTaskTest(){
        // precondition
        given(taskRepository.save(task)).willReturn(task);

        //action
        Task savedTask = taskService.createTask(task);

        // verify the output
        System.out.println(savedTask);
        assertThat(savedTask).isNotNull();
    }

    @Test
    @Order(2)
    public void getTaskById(){
        // precondition
        given(taskRepository.findById(1L)).willReturn(Optional.of(task));

        // action
        Task existingTask = taskService.getTaskById(task.getId()).get();

        // verify
        System.out.println(existingTask);
        assertThat(existingTask).isNotNull();

    }


    @Test
    @Order(3)
    public void getAllTask(){
        Task task1 = Task.builder()
                .id(2L)
                .name("task1")
                .description("task1 for test service ")
                .deadline(LocalDate.parse("2024-05-02"))
                .build();

        // precondition
        given(taskRepository.findAll()).willReturn(List.of(task,task1));

        // action
        List<Task> taskList = taskService.getAllTasks();

        // verify
        System.out.println(taskList);
        assertThat(taskList).isNotNull();
        assertThat(taskList.size()).isGreaterThan(1);
    }



    @Test
    @Order(4)
    public void deleteTask(){

        // precondition
        willDoNothing().given(taskRepository).deleteById(task.getId());

        // action
        taskService.deleteTask(task.getId());

        // verify
        verify(taskRepository, times(1)).deleteById(task.getId());
    }


}
