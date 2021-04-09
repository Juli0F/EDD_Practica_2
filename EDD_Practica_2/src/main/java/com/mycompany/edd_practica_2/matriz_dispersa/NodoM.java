/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd_practica_2.matriz_dispersa;

/**
 *
 * @author Temporal
 */
public class NodoM <T>{
    
    
    private int posX;
    private int posY;
    private T value;
    private NodoM<T> arriba;
    private NodoM<T> abajo;
    private NodoM<T> izquierda ;
    private NodoM<T> derecha;

    public NodoM(int posX, int posY, T value) {
        this.posX = posX;
        this.posY = posY;
        this.value = value;
    }
    public NodoM(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        
    }
    public NodoM(int posX, int posY, T value, NodoM<T> arriba, NodoM<T> abajo, NodoM<T> izquierda, NodoM<T> derecha) {
        this.posX = posX;
        this.posY = posY;
        this.value = value;
        this.arriba = arriba;
        this.abajo = abajo;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public NodoM<T> getArriba() {
        return arriba;
    }

    public void setArriba(NodoM<T> arriba) {
        this.arriba = arriba;
    }

    public NodoM<T> getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoM<T> abajo) {
        this.abajo = abajo;
    }

    public NodoM<T> getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoM<T> izquierda) {
        this.izquierda = izquierda;
    }

    public NodoM<T> getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoM<T> derecha) {
        this.derecha = derecha;
    }

    @Override
    public String toString() {
        String cadena = "";
        
        if (arriba != null) {
            cadena = "Arriba : ["+arriba.getPosX()+","+arriba.getPosY()+"], Value "+arriba.getValue();
        }
        if (abajo != null) {
            cadena += "Abajo : ["+abajo.getPosX()+","+abajo.getPosY()+"], Value "+abajo.getValue();
        }
        if (derecha != null) {
            cadena += "derecha : ["+derecha.getPosX()+","+derecha.getPosY()+"], Value "+derecha.getValue();
        }
        if (izquierda != null) {
            cadena += "izquierda : ["+izquierda.getPosX()+","+izquierda.getPosY()+"], Value "+izquierda.getValue();
        }
        
        return "Actual{" + "posX=" + posX + ", posY=" + posY + ", value=" + value.toString() +", "+ cadena+ '}';
    }

    
    
    
    
}