package com.zloebok.todoproject.service;

import com.zloebok.todoproject.DTO.ToDoItemDTO;
import com.zloebok.todoproject.mapper.Mapper;
import com.zloebok.todoproject.mapper.MapperImpl;
import com.zloebok.todoproject.repository.ToDoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ToDoService {

    @Autowired
    private final ToDoRepository toDoRepository;
    private final Mapper mapper = new MapperImpl();

    public List<ToDoItemDTO> getAllToDo() {

        return toDoRepository.findAll().stream()
                .map(mapper::ToDoEntityToDTO)
                .toList();
    }

    public ToDoItemDTO createToDo(ToDoItemDTO itemDTO) {

        toDoRepository.save(mapper.ToDoDTOToEntity(itemDTO));

        return itemDTO;
    }

    public void deleteToDo(Long id) {
        toDoRepository.deleteById(id);
    }

    public void updateToDo(ToDoItemDTO toDoItemDTO) {

        if (toDoRepository.findById(toDoItemDTO.getId()).isEmpty()) {
            throw new NoSuchElementException();
        }

        toDoRepository.updateDescriptionAndUpdatedById
                        (toDoItemDTO.getDescription(),
                        new Date(),
                        toDoItemDTO.getId());

    }

}
