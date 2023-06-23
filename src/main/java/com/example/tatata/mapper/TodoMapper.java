package com.example.tatata.mapper;


import com.example.tatata.DTO.TodoDTO;
import com.example.tatata.model.Todo;

import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface TodoMapper {

    TodoMapper mapper = Mappers.getMapper(TodoMapper.class);

    TodoDTO mapTodoToDTO(Todo todo);

    Todo todoDtoToEntity(TodoDTO todoDTO);

    }
