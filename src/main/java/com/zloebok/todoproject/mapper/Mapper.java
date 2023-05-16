package com.zloebok.todoproject.mapper;

import com.zloebok.todoproject.DTO.ToDoItemDTO;
import com.zloebok.todoproject.entity.ToDoEntity;

@org.mapstruct.Mapper
public interface Mapper {

    ToDoItemDTO ToDoEntityToDTO(ToDoEntity entity);
    ToDoEntity ToDoDTOToEntity(ToDoItemDTO toDoItemDTO);
}
