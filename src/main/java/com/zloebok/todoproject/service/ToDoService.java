package com.zloebok.todoproject.service;

import com.zloebok.todoproject.DTO.ToDoItemDTO;
import com.zloebok.todoproject.mapper.MapperImpl;
import com.zloebok.todoproject.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;
    MapperImpl mapper = new MapperImpl();

    public List<ToDoItemDTO> getAllToDo() {

        List<ToDoItemDTO> dtoList = toDoRepository.findAll().stream()
                .map(item -> mapper.ToDoEntityToDTO(item))
                .toList();

        return dtoList;
    }

    public ToDoItemDTO createToDo(ToDoItemDTO itemDTO) {

        toDoRepository.save(mapper.ToDoDTOToEntity(itemDTO));

        return itemDTO;
    }

}
