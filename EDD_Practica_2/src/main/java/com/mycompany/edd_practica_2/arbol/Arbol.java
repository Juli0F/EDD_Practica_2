/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd_practica_2.arbol;

/**
 *
 * @author Temporal
 */
public class Arbol<T> {
    
   private Nodo<T>  root;

    public Arbol(Nodo<T> root) {
        this.root = root;
    }

    public Arbol() {
        this.root = null;
    }
    
    public Nodo<T> buscar(int id, T valor, Nodo<T> nodo){
        
        if (root == null) {
            return null;
        }else if (nodo.getId() == id){
            return nodo;
        }else if (nodo.getId() < id) {
            return buscar(id,valor,nodo.getDerecho());
        }else {
            return buscar(id,valor,nodo.getIzquierdo());
        }
    }
    /**
     * obtener el factor de equilibrio del subarbol
     * @param nodo
     * @return 
     */
    public int getFacEquilibrio(Nodo<T> nodo){
        if (nodo == null) {
            return -1;
        }else{
            return nodo.getFactEq();
        }
    }
    
    /**
     * rotacion izquierda
     */
    public Nodo<T> rotacionSimpleIzquierda(Nodo<T> nodo){
    
        Nodo<T> aux = nodo.getIzquierdo();
        
        nodo.setIzquierdo(aux.getDerecho());
        aux.setDerecho(nodo);
        nodo.setFactEq(
                Math.max(
                        getFacEquilibrio(nodo.getIzquierdo()),
                        getFacEquilibrio(nodo.getDerecho()))
        +1);
        
        
        aux.setFactEq(
                Math.max(
                        getFacEquilibrio(aux.getIzquierdo()),
                        getFacEquilibrio(aux.getDerecho()))
        +1);
        
        
        return aux;
    }
    
    
    /**
     * rotacion derecha
     */
    public Nodo<T> rotacionSimpleDerecha(Nodo<T> nodo){
    
        Nodo<T> aux = nodo.getDerecho();
        
        nodo.setDerecho(aux.getIzquierdo());
        aux.setIzquierdo(nodo);
        
        nodo.setFactEq(
                Math.max(
                        getFacEquilibrio(nodo.getIzquierdo()),
                        getFacEquilibrio(nodo.getDerecho()))
        +1);
        
        
        aux.setFactEq(
                Math.max(
                        getFacEquilibrio(aux.getIzquierdo()),
                        getFacEquilibrio(aux.getDerecho()))
        +1);
        
        
        return aux;
    }
    
    
    public Nodo<T> rotacionDobleIzquierda(Nodo<T> nodo){
        
        Nodo<T> aux ;
        
        nodo.setIzquierdo(rotacionSimpleDerecha(nodo.getIzquierdo()));
        aux = rotacionSimpleIzquierda(nodo);
        return aux;
    }
    
    public Nodo<T> rotacionDobleDerecha(Nodo<T> nodo){
        
        Nodo<T> aux ;
        
        nodo.setDerecho(rotacionSimpleIzquierda(nodo.getDerecho()));
        aux = rotacionSimpleDerecha(nodo);
        return aux;
    }
    
    public Nodo<T> insertarAVL(Nodo<T> nuevo , Nodo<T> sub){
        Nodo<T> padre = sub;
        if (nuevo.getId() < sub.getId()) {
            if (sub.getIzquierdo() == null) {
                 sub.setIzquierdo(nuevo); 
            }else{
                sub.setIzquierdo(insertarAVL(nuevo , sub.getIzquierdo() ));
                
                if(getFacEquilibrio(sub.getIzquierdo()) - getFacEquilibrio(sub.getDerecho()) == 2) {
                    
                    if(nuevo.getId() < sub.getIzquierdo().getId()){
                        
                        padre = rotacionSimpleIzquierda(sub);
                        
                    }else{
                        padre = rotacionDobleIzquierda(sub);
                    }
                }
            }
        }else if(nuevo.getId() > sub.getId()){
            
            if (sub.getDerecho()== null) {
                 sub.setDerecho(nuevo); 
            }else{
                sub.setDerecho(insertarAVL(nuevo , sub.getDerecho()));
                
                if(getFacEquilibrio(sub.getDerecho()) - getFacEquilibrio(sub.getIzquierdo()) == 2) {
                    
                    if(nuevo.getId() < sub.getDerecho().getId()){
                        
                        padre = rotacionSimpleDerecha(sub);
                        
                    }else{
                        padre = rotacionDobleDerecha(sub);
                    }
                }
            }
            
            
        }else{
            
            System.out.println("Nodo Duplicado");
        }
        
        if (sub.getIzquierdo() == null && sub.getDerecho() != null) {
            sub.setFactEq(sub.getDerecho().getFactEq()+1);
        }else if (sub.getDerecho()== null && sub.getIzquierdo()!= null) {
            sub.setFactEq(sub.getIzquierdo().getFactEq()+1);
        }else{
            
            sub.setFactEq(
                    Math.max(
                            getFacEquilibrio(sub.getIzquierdo()),
                            getFacEquilibrio(sub.getDerecho())
                    )
                    +1
            );
        }
        
        
        return padre;
    }
    
    public void insertar(int id, T valor){
        
            
        Nodo<T> nuevo = new Nodo<T>(id, valor);
        
        if (root == null) {
            root = nuevo;
        }else{
             root=insertarAVL(nuevo, root);
        }
    }
    
    
    /***********************   Recorridos *************************************/
    
    public void inOrden (Nodo<T> nodo){
        if (nodo != null) {
            inOrden(nodo.getIzquierdo());
            System.out.println(nodo.getId() + "  ,   ");
            inOrden(nodo.getDerecho());
            
        }
    }
    
    public void preOrden(Nodo<T> nodo){
        
        if (nodo != null) {
            System.out.println(nodo.getId() + "  ,   ");
            preOrden(nodo.getIzquierdo());
            preOrden(nodo.getDerecho());
            
        }
    }
    public void postOrden(Nodo<T> nodo){
        
        if (nodo != null) {
            
            postOrden(nodo.getIzquierdo());
            preOrden(nodo.getDerecho());
            
            System.out.println(nodo.getId() + "  ,   ");
            
        }
    }
}
