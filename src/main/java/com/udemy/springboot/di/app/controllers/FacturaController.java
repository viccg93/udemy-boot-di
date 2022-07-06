package com.udemy.springboot.di.app.controllers;

import com.udemy.springboot.di.app.models.domain.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //Es singleton por defecto
@RequestMapping("/factura")
public class FacturaController {
    @Autowired
    private Factura factura;
    @GetMapping("/ver")
    public String ver(Model model){
        model.addAttribute("titulo", "Ver factura con inyeccion de dependencia");
        model.addAttribute("factura", factura);
        return "factura/ver";
    }
}
