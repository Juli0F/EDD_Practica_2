/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd_practica_2.listas;

import com.mycompany.edd_practica_2.matriz_dispersa.Capa;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.engine.GraphvizLoader;

/**
 *
 * @author Temporal
 */
public class ListaDoble<T> {

    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int cantElementos;

    public ListaDoble() {
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    public Nodo<T> find(T value) {
        Nodo<T> temp = primero;

        if (primero != null) {
            if (primero.getValue().hashCode() == value.hashCode()) {
                return primero;
            }
            
            while(temp.getSiguiente() != null){
                
                if (temp.getSiguiente().getValue().hashCode() == value.hashCode()) {
                    return temp.getSiguiente();
                }
                temp = temp.getSiguiente();
            }
            
        }

        return null;
    }

    public ListaDoble(Nodo<T> primero, Nodo<T> ultimo, int cantElementos) {
        this.primero = primero;
        this.ultimo = ultimo;
        this.cantElementos = cantElementos;
    }

    public void insertar(T value) {
        Nodo<T> nuevo = new Nodo<>(value, null, null, 0);

        if (primero == null) {
            System.out.println("Primero insertado");
            this.primero = nuevo;
            if (value instanceof Capa) {
                Capa<String> capa = (Capa<String>) value;
                primero.setId(capa.getId());
            } else {
                primero.setId(1);
            }

            //   this.ultimo = nuevo;
        } else {
            insertar(nuevo);

        }
    }

    public void insertar(Nodo<T> nodo) {

        if (primero == null) {
            this.primero = nodo;

        } else {
            int contTemp = 2;
            Nodo<T> temp = primero;

            while (temp.getSiguiente() != null) {
                contTemp++;
                temp = temp.getSiguiente();
            }

            temp.setSiguiente(nodo);
            temp.getSiguiente().setAnterior(temp);

            if (nodo.getValue() instanceof Capa) {
                Capa<String> capa = (Capa<String>) nodo.getValue();
                temp.getSiguiente().setId(capa.getId());
            } else {
                temp.getSiguiente().setId(contTemp);
            }

            System.out.println("Nodo Insertado en la lista " + temp.getSiguiente().getValue());
        }

    }

    public void eliminar(int idNodo) {
        if (primero != null) {

            if (idNodo == primero.getId()) {
                primero = primero.getSiguiente();
                primero.setAnterior(null);

            } else {

                Nodo<T> temp = primero.getSiguiente();

                while (temp != null) {

                    if (temp.getId() == idNodo) {

                        temp.getAnterior().setSiguiente(temp.getSiguiente());
                        temp.getSiguiente().setAnterior(temp.getAnterior());
                        return;

                    } else {
                        temp = temp.getSiguiente();
                    }
                }

            }
        }
    }

    public void eliminar(Nodo<T> nodo) {
        if (primero != null) {

            if (nodo.equals(nodo)) {
                primero = primero.getSiguiente();
                primero.setAnterior(null);

            } else {

                Nodo<T> temp = primero.getSiguiente();

                while (temp != null) {

                    if (temp.equals(nodo)) {

                        temp.getAnterior().setSiguiente(temp.getSiguiente());
                        temp.getSiguiente().setAnterior(temp.getAnterior());
                        return;

                    } else {
                        temp = temp.getSiguiente();
                    }
                }

            }
        }
    }

    public void imprimir() {
        Nodo<T> temp = primero;

        while (temp != null) {

            System.out.println(temp.toString());
            System.out.println("");
            temp = temp.getSiguiente();

        }
    }

    public void recorrerLstGraph() {
        Nodo<T> temp = primero;
        //Graphviz gv = new Graphviz(temp);

        String cadena = "digraph Figura{\n\t";

        while (temp != null) {

            cadena += temp.getId();;
            if (temp.getSiguiente() != null) {
                cadena += " -> " + temp.getSiguiente().getId() + ";\n\t";
                cadena += temp.getSiguiente().getId() + " -> " + temp.getId() + ";\n\t";
            }
            temp = temp.getSiguiente();

        }
        cadena += "\n}";
        System.out.println(cadena);

    }

    public void actualizar(Nodo<T> old, Nodo<T> nEW) {
        if (primero.getId() == old.getId()) {
            primero.setValue(nEW.getValue());

        } else {

            Nodo<T> temp = primero.getSiguiente();

            while (temp != null) {

                if (temp.getId() == old.getId()) {

                    temp.setValue(nEW.getValue());
                    return;
                } else {
                    temp = temp.getSiguiente();
                }
            }

        }
    }
}
