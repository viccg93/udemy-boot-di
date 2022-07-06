package com.udemy.springboot.di.app;

import com.udemy.springboot.di.app.models.domain.ItemFactura;
import com.udemy.springboot.di.app.models.domain.Producto;
import com.udemy.springboot.di.app.models.service.IService;
import com.udemy.springboot.di.app.models.service.MyService;
import com.udemy.springboot.di.app.models.service.MyServiceComplex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

//esta forma se usa cuando se require inyectar objetos externos a la aplicacion, en caso contrario @Component funciona perfecto
@Configuration //las clases de configuracion de spring deben de estar en el package principal
public class AppConfig {
    @Bean("simpleService")
    public IService registrarServicio(){
        return new MyService();
    }

    @Bean("complexService")
    public IService registrarComplexService(){
        return new MyServiceComplex();
    }

    @Bean("itemsFactura")
    public List<ItemFactura> registrarItems(){
        Producto producto1 = new Producto("Infinite Jest", 400);
        Producto producto2 = new Producto("Antioedipus", 200);

        ItemFactura item1 = new ItemFactura(producto1,2);
        ItemFactura item2 = new ItemFactura(producto2,1);

        return Arrays.asList(item1,item2);
    }

    @Bean("itemsFacturaOficina")
    public List<ItemFactura> registrarItemsOficina(){
        Producto producto1 = new Producto("Monitor", 8000);
        Producto producto2 = new Producto("Impresora", 2000);
        Producto producto3 = new Producto("Escritorio", 2500);

        ItemFactura item1 = new ItemFactura(producto1,2);
        ItemFactura item2 = new ItemFactura(producto2,1);
        ItemFactura item3 = new ItemFactura(producto3,1);

        return Arrays.asList(item1,item2, item3);
    }
}
