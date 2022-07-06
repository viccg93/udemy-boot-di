package com.udemy.springboot.di.app.models.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Component
public class Factura {
    @Value("${factura.descripcion}")
    private String descripcion;
    @Autowired
    private Cliente cliente;
    @Autowired
    @Qualifier("itemsFacturaOficina")
    private List<ItemFactura> items;

    @PostConstruct //Se ejecuta despues de realizar la inyeccion de dependencias
    public void init(){
        this.setDescripcion("Factura de " + this.getDescripcion() + " del cliente " + this.getCliente().getNombre());
    }
    @PreDestroy //Se ejecuta antes de destruir los beans, singleton y mueren al detener la app
    public void destruir(){
        System.out.println("Destruyendo " + this.getDescripcion());
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemFactura> getItems() {
        return items;
    }

    public void setItems(List<ItemFactura> items) {
        this.items = items;
    }
}
