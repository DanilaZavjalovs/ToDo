package com.zloebok.todoproject.controller;

import com.zloebok.todoproject.DTO.ToDoItemDTO;
import com.zloebok.todoproject.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/toDo")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping
    public ResponseEntity<List<ToDoItemDTO>> getAllToDo() {
        List<ToDoItemDTO> dtoList = toDoService.getAllToDo();

        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ToDoItemDTO> createToDo(@RequestBody ToDoItemDTO itemDTO) {
        return new ResponseEntity<>(toDoService.createToDo(itemDTO), HttpStatus.CREATED);
    }

}
