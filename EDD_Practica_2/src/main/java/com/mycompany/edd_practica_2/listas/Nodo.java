/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd_practica_2.listas;

import java.util.Objects;

/**
 *
 * @author Temporal
 */
public class Nodo<T> {
    private T value;
    private int id;
    
    private Nodo<T> siguiente;
    private Nodo<T> anterior;

    public Nodo() {
    }
    
    public Nodo(T value, Nodo<T> siguiente, Nodo<T> anterior, int id) {
        this.value = value;
        this.siguiente = siguiente;
        this.anterior = anterior;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.value);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Nodo<?> other = (Nodo<?>) obj;
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String cadena = "";
        if (anterior!= null) {
            cadena = ", anterior=" + anterior.getId() ;
        }
        if (siguiente != null) {
            cadena +=", siguiente=" + siguiente.getId();
        }
        return "Nodo{"+ "value=" + value.toString() + ", id=" + id  +  cadena +'}';
        
       
    }

    
    
    
}
