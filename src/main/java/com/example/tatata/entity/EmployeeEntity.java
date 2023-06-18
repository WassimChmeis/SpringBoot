package com.example.tatata.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
@Getter@Setter
public class EmployeeEntity {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "emp_name")
    private String name;
    @Column(name = "emp_email")
    private String email;
    @Column(name = "salary")
    private double salary;


}
