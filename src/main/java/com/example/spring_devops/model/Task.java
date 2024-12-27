package com.example.spring_devops.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@Table(name="Task")
@AllArgsConstructor
@NoArgsConstructor

public class Task implements Serializable {

 @Id
 @GeneratedValue
 private Long id ;

    private String name;
    private String description;
    private LocalDate deadline;




}
