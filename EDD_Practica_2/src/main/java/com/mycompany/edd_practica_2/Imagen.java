/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd_practica_2;

import com.mycompany.edd_practica_2.arbol.Nodo;
import com.mycompany.edd_practica_2.listas.ListaDoble;
import com.mycompany.edd_practica_2.matriz_dispersa.Capa;

/**
 *
 * @author Temporal
 */
public class Imagen {

    private ListaDoble<Capa<String>> capas;
    private int id;

    public Imagen(int id) {
        this.id  = id;
        this.capas = new ListaDoble<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public ListaDoble<Capa<String>> getCapas() {
        return capas;
    }

    public void insertarEnListaDoble(Capa<String> nodo){
        capas.insertar(nodo);
    }
    public void setCapas(ListaDoble<Capa<String>> capas) {
        this.capas = capas;
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
        final Imagen other = (Imagen) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Imagen{" + "id=" + id + '}';
    }
    

    
    
}
