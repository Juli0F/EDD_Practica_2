/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd_practica_2.arbol;

import com.mycompany.edd_practica_2.CapaLoad;
import java.util.List;

/**
 *
 * @author Temporal
 */
public class Nodo<T> {

    private int id;
    private int factEq;
    private T  valor;
    
    
    private Nodo<T> izquierdo;
    private Nodo<T> derecho;
    

    public Nodo(int id, T valor) {
        this.id = id;
        this.valor = valor;
        this.factEq = 0;
        

    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFactEq() {
        return factEq;
    }

    public void setFactEq(int factEq) {
        this.factEq = factEq;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public Nodo<T> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo<T> getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo<T> derecho) {
        this.derecho = derecho;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
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
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    

}
