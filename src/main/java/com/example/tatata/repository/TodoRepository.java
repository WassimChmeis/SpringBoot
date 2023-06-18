package com.example.tatata.repository;

import com.example.tatata.entity.EmployeeEntity;
import com.example.tatata.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TodoRepository extends JpaRepository<Todo,Integer> {

    //EmployeeEntity findEmployeeById(int id);
}
