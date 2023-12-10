package com.example.algoritmos;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Movimiento implements Serializable {
    private String tipo;
    private String categoria;
    private LocalDateTime fecha;
    private double monto;
    private String Descripcion;

    public double getMonto() {
        return monto;
    }

    public String getTipo() {
        return tipo;
    }

    public Movimiento(String tipo, String categoria, LocalDateTime fecha, double monto, String descripcion) {
        this.tipo = tipo;
        this.categoria = categoria;
        this.fecha = fecha;
        this.monto = monto;
        Descripcion = descripcion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    Movimiento(String type, String Cate, double amount, String text){
        this.tipo=type;
        this.categoria=Cate;
        this.monto=amount;
        fecha= LocalDateTime.now();
    }
    public void getValue(){
        System.out.println("tipo: "+tipo+"\nCategoria: "+categoria+"\nmonto: "+monto+"\nfecha: "+fecha);
    }

    public String getCategoria() {
        return categoria;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
}
