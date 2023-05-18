package com.zloebok.todoproject.service;

import com.zloebok.todoproject.DTO.ToDoItemDTO;
import com.zloebok.todoproject.mapper.Mapper;
import com.zloebok.todoproject.mapper.MapperImpl;
import com.zloebok.todoproject.repository.ToDoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
@AllArgsConstructor
public class HomeService {

    @Autowired
    private final ToDoRepository toDoRepository;
    private final Mapper mapper = new MapperImpl();

    public ModelAndView getHome() {
        ModelAndView modelAndView = new ModelAndView("home");

        List<ToDoItemDTO> dtoList = toDoRepository.findAll().stream()
                .map(mapper::ToDoEntityToDTO)
                        .toList();

        modelAndView.addObject("ToDoList", dtoList);

        return modelAndView;
    }
}
