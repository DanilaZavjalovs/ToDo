package com.zloebok.todoproject.controller;

import com.zloebok.todoproject.service.HomeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class HomeController {

    @Autowired
    private final HomeService homeService;

    @GetMapping
    public ModelAndView getHome() {
        return homeService.getHome();
    }

}
