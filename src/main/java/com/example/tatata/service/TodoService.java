package com.example.tatata.service;


import com.example.tatata.DTO.TodoDTO;
import com.example.tatata.mapper.TodoMapper;
import com.example.tatata.model.Todo;
import com.example.tatata.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoMapper todoMapper;
    private TodoRepository todoRepository;



    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    public  TodoDTO getById(int id) {
        TodoDTO todoDTO = todoMapper.mapTodoToDTO(todoRepository.findById(id).get());
        return  todoDTO;
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
    public List<TodoDTO> findAll(){

        List<Todo> todos = todoRepository.findAll();
        List<TodoDTO> todoDTOS = todos.stream().map(todoMapper::mapTodoToDTO).collect(Collectors.toList());
        //List<TodoDTO> todoDTOS = todoMapper.mapTodoToDTO(todoRepository.findAll());
        return todoDTOS;
    }

    public Todo save(Todo todo){
        return todoRepository.save(todo);
    }


    public ResponseEntity<String> delete(int id) {
        try {
            todoRepository.deleteById(id);
            return ResponseEntity.ok("Todo item deleted successfully");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The List is empty");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(String.format("Failed to delete todo item: %s", e.getMessage()));
        }
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