package com.udemy.springboot.di.app.models.service;

import org.springframework.stereotype.Component;
//se anota como componente que se va a inyectar y es singleton (component o service)
//@Component("simpleService")
public class MyService implements IService{
    //los componentes deben de tener un contructor sin argumentos en caso de tene rmultiples constructores (explicito)
    @Override
    public String operacion() {
        return "ok";
    }
}
