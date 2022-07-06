package com.udemy.springboot.di.app.controllers;

import com.udemy.springboot.di.app.models.service.IService;
import com.udemy.springboot.di.app.models.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class IndexController {

    @Autowired //inyeccion de campo
    @Qualifier("complexService") //indica cual es la implementacion a usar, definida en component
    private IService service;
    @GetMapping({"/","","/index"})
    public String index(Model model){
        model.addAttribute("titulo", "inyeccion service");
        model.addAttribute("result", service.operacion());
        return "index";
    }
}
