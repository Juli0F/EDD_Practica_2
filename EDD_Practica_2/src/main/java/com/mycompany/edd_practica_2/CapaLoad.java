/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd_practica_2;

/**
 *
 * @author Temporal
 */
public class CapaLoad {
    private static  int id3;
    private int id;
    private int fila;
    private int columna;
    private String color;

    public CapaLoad() {
    }

    public CapaLoad(int fila, int columna, String color) {
        this.fila = fila;
        this.columna = columna;
        this.color = color;
//        ImgLoad m = new ImgLoad();
//        m.getCapas().add(id)
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
            
    
}
