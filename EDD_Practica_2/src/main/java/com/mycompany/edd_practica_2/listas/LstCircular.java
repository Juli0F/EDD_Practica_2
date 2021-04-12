/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd_practica_2.listas;

/**
 *
 * @author Temporal
 */
public class LstCircular<T> {

    private Nodo<T> primero;
    private Nodo<T> ultimo;

    public LstCircular() {

        this.primero = null;
        this.ultimo = null;

    }

    public LstCircular(Nodo<T> primero, Nodo<T> ultimo) {
        this.primero = primero;
        this.ultimo = ultimo;
    }

    public void insertar(T value) {

        Nodo<T> nuevo = new Nodo<>();
        nuevo.setValue(value);

        if (primero == null) {

            nuevo.setId(1);
            primero = nuevo;
            primero.setSiguiente(primero);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;

        } else {
            Nodo<T> temp = nuevo;
            nuevo.setId(ultimo.getId() + 1);

            ultimo.setSiguiente(nuevo);
            nuevo.setSiguiente(primero);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;
            primero.setAnterior(ultimo);

        }

    }

    public void mostrar() {

        Nodo<T> temp = new Nodo<>();
        temp = primero;
        while (temp != null) {

            System.out.println(temp.toString());
            temp = temp.getSiguiente();

            if (temp.getId() == primero.getId()) {
                return;
            }
        }

    }

    public String recorrerLstGraph() {

        Nodo<T> temp = new Nodo<>();
        temp = primero;
        String cadena = "digraph Figura{\n\t";
        while (temp != null) {

            cadena += temp.getId();
            if (temp.getSiguiente() != null) {
                cadena += " -> " + temp.getSiguiente().getId() + ";\n\t";
                cadena += temp.getSiguiente().getId() + " -> " + temp.getId() + ";\n\t";
            }

            temp = temp.getSiguiente();

            if (temp.getId() == primero.getId()) {
                cadena += "\n}";
                System.out.println(cadena);
                return cadena+"\n}";
            }
        }

        cadena += "\n}";
        System.out.println(cadena);
        return cadena;
        

    }

    public void mostrarDesc() {

        Nodo<T> temp = new Nodo<>();
        temp = ultimo;
        while (temp != null) {

            System.out.println(temp.toString());
            temp = temp.getSiguiente();

            if (temp.getId() == ultimo.getId()) {
                return;
            }
        }

    }

    public Nodo<T> buscar(T value) {

        Nodo<T> actual = new Nodo<>();

        actual = ultimo;

        boolean find = false;

        while (actual != null) {

            if (actual.getValue().hashCode() == value.hashCode()) {
                return actual;
            }
            actual = actual.getAnterior();

        }

        System.out.println("No encontrado");
        return null;

    }

    public Nodo<T> buscar(int idValue) {

        Nodo<T> actual = new Nodo<>();
        actual = ultimo;

        boolean find = false;

        while (actual != null) {

            if (actual.getValue().hashCode() == idValue) {
                return actual;
            }
            actual = actual.getAnterior();

        }

        return null;

    }

    public void ordenar() {

    }

}
