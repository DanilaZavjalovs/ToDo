package com.zloebok.todoproject.mapper;

import com.zloebok.todoproject.DTO.ToDoItemDTO;
import com.zloebok.todoproject.entity.ToDoEntity;

public class MapperImpl implements Mapper {

    @Override
    public ToDoItemDTO ToDoEntityToDTO(ToDoEntity entity) {
        return ToDoItemDTO.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .created(entity.getCreated())
                .updated(entity.getUpdated())
                .build();
    }

    @Override
    public ToDoEntity ToDoDTOToEntity(ToDoItemDTO toDoItemDTO) {
        ToDoEntity entity = new ToDoEntity();
        entity.setDescription(toDoItemDTO.getDescription());

        return entity;
    }
}
