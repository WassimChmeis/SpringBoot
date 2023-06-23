package com.example.tatata.controller;


import com.example.tatata.DTO.TodoDTO;
import com.example.tatata.mapper.TodoMapper;
import com.example.tatata.model.Todo;
import com.example.tatata.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/todos")
public class TodoController {

    @Autowired
    private TodoMapper todoMapper;

    @Autowired
    private TodoService todoService;

    @GetMapping({"","/"})
    public List<TodoDTO> getAllTodos(){
        return todoService.findAll();
    }

    @GetMapping({"/{id}"})
    public TodoDTO getTodoById(@PathVariable int id){
        //TodoDTO todoDTO = todoMapper.mapTodoToDTO(todoService.getById(id));
        TodoDTO todoDTO = todoService.getById(id);
        return todoDTO;
    }

    @PostMapping ({"","/"})
    public Todo createNewTodoItem(@RequestBody Todo todo){
        return todoService.save(todo);
    }

    @DeleteMapping({ "/{id}"})
    public ResponseEntity DeleteTodoItem(@PathVariable int id){

        return todoService.delete(id);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<String> updateTodoItem(@PathVariable int id, @RequestBody TodoDTO todoDTO) {
        try {
            todoDTO.setId(id);
            todoService.updateTodoItem(todoDTO);
            return ResponseEntity.ok("Todo item updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update todo item");
        }
    }
}
