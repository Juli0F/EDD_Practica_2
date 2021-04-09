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
public class Matriz<T> {
    
    private NodoM<T> root;
    private int filas;
    private int columnas;
    private int nodos;

    public Matriz() {
        
        root = new NodoM<T>(0,0);
                
    }
    public NodoM<T> crearNodo(int posX, int posY, T value){
        return new NodoM<T>(posX, posY, value);
    }
    
    
    public NodoM<T> insertarFila(int fila){
        
        NodoM<T> guia = root.getAbajo();
        NodoM<T> nuevo = new NodoM<T>(0,fila);
        
        if (guia == null) {
            root.setAbajo(nuevo);   // el nodo de  arriba apunta al de abajo, la primera fila apunta a la siguiente fila
            nuevo.setArriba(root);  // el segundo nodo apunta al de arriba, la segunda fila apunta a la primera fila
        }else{
            //vrga el problema aca es de que una fila puede no existir
            //verificar si 
            
            if (guia.getPosY() >  fila) {
                nuevo.setAbajo(guia);
                guia.setArriba(nuevo);
                root.setAbajo(nuevo);
                nuevo.setAbajo(root);
            }else{
                NodoM<T> aux = guia;
                while(aux.getAbajo() != null){
                    if (aux.getAbajo().getPosY() < fila) {
                        nuevo.setAbajo(aux.getAbajo());
                        aux.getAbajo().setArriba(nuevo);
                        nuevo.setArriba(aux);
                        aux.setAbajo(nuevo);
                        this.filas++;
                        return nuevo;
                    }
                    
                    aux = aux.getAbajo();
                }
                aux.setAbajo(nuevo);
                nuevo.setArriba(aux);
            }
            
            
        }
        
        if (fila > this.filas) {
            this.filas = fila;
            
        }
         return nuevo;
    }
    
    public NodoM<T> insertarColumna(int columna){
         
        NodoM<T> guia = root.getDerecha();
        NodoM<T> nuevo = new NodoM<T>(0,columna);
        
        if (guia == null) {
            root.setDerecha(nuevo);   // el nodo de  arriba apunta al de abajo, la primera fila apunta a la siguiente fila
            nuevo.setIzquierda(root);  // el segundo nodo apunta al de arriba, la segunda fila apunta a la primera fila
        }else{
            //vrga el problema aca es de que una fila puede no existir
            //verificar si 
            
            if (guia.getPosX() >  columna) {
                nuevo.setDerecha(guia);
                guia.setIzquierda(nuevo);
                root.setDerecha(nuevo);
                nuevo.setIzquierda(root);
            }else{
                NodoM<T> aux = guia;
                while(aux.getDerecha()!= null){
                    if (aux.getDerecha().getPosX() < columna) {
                        nuevo.setDerecha(aux.getDerecha());
                        aux.getDerecha().setIzquierda(nuevo);
                        nuevo.setIzquierda(aux);
                        aux.setDerecha(nuevo);
                        this.columnas++;
                        return nuevo;
                    }
                    
                    aux = aux.getDerecha();
                }
                aux.setDerecha(nuevo);
                nuevo.setIzquierda(aux);
            }
            
            
        }
        
        if (columnas > this.columnas) {
            this.columnas = columna;
            
        }
         return nuevo;
        
    }
    
    public NodoM<T> getFilaNodo(int fila, boolean flag){
        
        NodoM<T> aux = root.getAbajo();
        
        
        while(aux != null){
            
            if (aux.getPosY() == fila) {
                return aux;
            }
            aux = aux.getAbajo();
            
        }
        if (flag) {
            return insertarFila(fila);
        }
        
        return null;
    }
    
    
    public NodoM<T> getColumnaNodo(int columna, boolean flag){
        
        NodoM<T> aux = root.getDerecha();
        
        
        while(aux != null){
            
            if (aux.getPosX() == columna) {
                return aux;
            }
            aux = aux.getDerecha();
            
        }
        if (flag) {
            return insertarColumna(columna);
        }
        
        return null;
    }
    public NodoM<T> triangular(int columna, int fila){
        
        
        NodoM<T>  nodoColumna = getColumnaNodo(columna, false);
        if (nodoColumna != null) {
            NodoM<T> aux = nodoColumna;
            
            while(aux != null){
                if (aux.getPosY() == fila) {
                    return aux;
                }
                aux = aux.getAbajo();
            }
        }
        return null;
    }
    
    public void insertar(int columna,int fila, T value){
        NodoM<T> nuevo = new NodoM<>(fila, columna, value);
        this.insertar(nuevo);
        
    }
    
    public void insertar(NodoM<T> nuevo){
        int fila = nuevo.getPosY();
        int columna = nuevo.getPosX();
        
        NodoM<T> initFila = getFilaNodo(fila, true);
        NodoM<T> inicioColumna = getColumnaNodo(columna, true);
        
        NodoM<T> cabeza = inicioColumna.getAbajo();
        
        if (cabeza == null) {
            inicioColumna.setAbajo(nuevo);
            nuevo.setArriba(inicioColumna);
        }else{
            if (cabeza.getPosY()>fila) {
                
                nuevo.setAbajo(cabeza);
                cabeza.setArriba(nuevo);
                inicioColumna.setAbajo(nuevo);
                nuevo.setArriba(inicioColumna);
                
            }else{
                NodoM<T> aux = cabeza;
                boolean insertado = false;
                
                while(aux.getAbajo() != null){
                
                    if (aux.getAbajo().getPosY() < fila) {
                        
                        nuevo.setAbajo(aux.getAbajo());
                        aux.getAbajo().setArriba(nuevo);
                        nuevo.setArriba(aux);
                        aux.setAbajo(nuevo);
                        insertado = true;
                        break;
                    }
                    aux = aux.getAbajo();
                }
                if (!insertado) {
                    aux.setAbajo(nuevo);
                    nuevo.setArriba(aux);
                }
            }
            
        }
        
        cabeza = initFila.getDerecha();
        if (cabeza == null) {
             initFila.setDerecha(nuevo);
             nuevo.setIzquierda(initFila);
        }else{
            
            if (cabeza.getPosX() > columna) {
                nuevo.setDerecha(cabeza);
                cabeza.setIzquierda(nuevo);
                initFila.setDerecha(nuevo);
                nuevo.setIzquierda(initFila);
            }else{
                 NodoM<T> aux = cabeza;
                boolean insertado = false;
                
                while(aux.getDerecha()!= null){
                
                    if (aux.getDerecha().getPosX() < columna) {
                        
                        nuevo.setDerecha(aux.getDerecha());
                        aux.getDerecha().setIzquierda(nuevo);
                        nuevo.setIzquierda(aux);
                        aux.setDerecha(nuevo);
                        insertado = true;
                        break;
                    }
                    aux = aux.getDerecha();
                }
                if (!insertado) {
                    aux.setDerecha(nuevo);
                    nuevo.setIzquierda(aux);
                }
            }
        }
        nodos++;
    }

    @Override
    public String toString() {
        return "Matriz{" + "root=" + root + ", filas=" + filas + ", columnas=" + columnas + ", nodos=" + nodos + '}';
    }
    
    public void imprimir(){
        NodoM<T> temp = root;
        System.out.println("nodos: "+ nodos);
       
        while (temp.getAbajo() != null) {
            
            
        }
    }
}
