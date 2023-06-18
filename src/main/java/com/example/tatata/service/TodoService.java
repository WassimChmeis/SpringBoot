package com.example.tatata.service;


import com.example.tatata.DTO.TodoDTO;
import com.example.tatata.model.Todo;
import com.example.tatata.repository.TodoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {


    private TodoRepository todoRepository;


    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    public  Todo getById(int id) {

        return  todoRepository.findById(id).get();
    }

    public void updateTodoItem(TodoDTO todoDTO) throws Exception {
        Optional<Todo> optionalTodoItem = todoRepository.findById(todoDTO.getId());
        if (optionalTodoItem.isPresent()) {
            Todo todoItem = optionalTodoItem.get();
            // Update only the necessary fields
            if (todoDTO.getTitle() != null) {
                todoItem.setTitle(todoDTO.getTitle());
            }
            if (todoDTO.getDescription() != null) {
                todoItem.setDescription(todoDTO.getDescription());
            }
            // Add more conditions to update other fields if necessary

            todoRepository.save(todoItem);
        } else {
            throw new Exception("Todo item not found");
        }
    }

    //Get all Todo items
    // return list of items
    public List<Todo> findAll(){
        return todoRepository.findAll();
    }

    public Todo save(Todo todo){
        return todoRepository.save(todo);
    }
    public void delete(int id){
        todoRepository.deleteById(id);
    }
}



  /*
    private static List<Todo> data = new ArrayList<>(
            Arrays.asList(
                    new Todo(1,"First Todo", "ajgd ashdshdh  djsa jl nasdv  kasd sj hkhd d"),
                    new Todo(2,"2nd Todo", "ajgd ashdshdh  djsa jl nasdv  kasd sj hkhd d"),
                    new Todo(3,"3rd Todo", "ajgd ashdshdh  djsa jl nasdv  kasd sj hkhd d"),
                    new Todo(4,"4th Todo", "ajgd ashdshdh  djsa jl nasdv  kasd sj hkhd d")
            )
    );*/