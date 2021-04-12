/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd_practica_2.matriz_dispersa;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Temporal
 */
public class Capa<T> {

    private int id;
    private NodoM<T> root;
    private int filas;
    private int columnas;
    private int nodos;
    private String cadena;
    private List<String> internos;
    private String subCadenaA;
    private List<String> grupos;

    public Capa(int id) {

        root = new NodoM<T>(0, 0);
        filas = 0;
        this.cadena = "";
        this.subCadenaA = "";
        this.internos = new ArrayList<>();
        this.grupos = new ArrayList<>();
        this.id = id;

    }

    private void resetCadena() {
        cadena = "digraph Sparce_Matrix {\n"
                + "\n"
                + "\tnode [shape=box]\n"
                + "\tMt[ label = \"0,0\", width = 1.5, style = filled, fillcolor = firebrick1, group = 1 ];\n"
                + "\te0[ shape = point, width = 0 ];\n"
                + "\te1[ shape = point, width = 0 ];\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NodoM<T> crearNodo(int posX, int posY, T value) {
        return new NodoM<T>(posX, posY, value);
    }

    public NodoM<T> insertarFilaBBorrar(int fila) {
        NodoM<T> nFila = new NodoM<>(0, fila);
        return insertFila(nFila, root.getAbajo());

    }

    public NodoM<T> insertFila(NodoM<T> fila, NodoM<T> comparacion) {

        if (comparacion == null) {
            comparacion = fila;
            filas++;
        } else {
            if (comparacion.getPosY() > fila.getPosY()) {
                NodoM<T> aux = comparacion.getArriba();

                aux.setAbajo(fila);
                fila.setAbajo(comparacion);

                comparacion.setArriba(fila);
                fila.setArriba(aux);
                filas++;

            } else {
                insertFila(fila, comparacion.getAbajo());
            }
        }
        return fila;
    }

    public NodoM<T> insertarFila(int fila) {

        NodoM<T> guia = root.getAbajo();
        NodoM<T> nuevo = new NodoM<T>(0, fila);

        if (guia == null) {
            root.setAbajo(nuevo);   // el nodo de  arriba apunta al de abajo, la primera fila apunta a la siguiente fila
            nuevo.setArriba(root);  // el segundo nodo apunta al de arriba, la segunda fila apunta a la primera fila
            filas++;
        } else {
            //vrga el problema aca es de que una fila puede no existir
            //verificar si 

            if (guia.getPosY() > fila) {
                nuevo.setAbajo(guia);
                guia.setArriba(nuevo);
                root.setAbajo(nuevo);
                nuevo.setArriba(root);
            } else {
                NodoM<T> aux = guia;
                while (aux.getAbajo() != null) {

                    if (aux.getAbajo().getPosY() > fila) {

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

    public NodoM<T> insertarColumna(int columna) {

        NodoM<T> guia = root.getDerecha();
        NodoM<T> nuevo = new NodoM<T>(columna, 0);

        if (guia == null) {
            root.setDerecha(nuevo);   // el nodo de  arriba apunta al de abajo, la primera fila apunta a la siguiente fila
            nuevo.setIzquierda(root);  // el segundo nodo apunta al de arriba, la segunda fila apunta a la primera fila
        } else {
            //vrga el problema aca es de que una fila puede no existir
            //verificar si 

            if (guia.getPosX() > columna) {
                nuevo.setDerecha(guia);
                guia.setIzquierda(nuevo);
                root.setDerecha(nuevo);
                nuevo.setIzquierda(root);
            } else {
                NodoM<T> aux = guia;
                while (aux.getDerecha() != null) {
                    if (aux.getDerecha().getPosX() > columna) {
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

    public NodoM<T> getFilaNodo(int fila, boolean flag) {

        NodoM<T> aux = root.getAbajo();

        while (aux != null) {

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

    private void recorrerFila(NodoM<T> nodo) {
        //NodoM<T> aux = root.getAbajo();

        if (nodo == root) {

            if (nodo.getAbajo() != null) {
                cadena += " \tU" + nodo.getAbajo().hashCode() + " [label =\"" + nodo.getAbajo().getPosX() + "," + nodo.getAbajo().getPosY() + "\" pos = \"5.3,3.5!\" width = 1.5 style = filled, fillcolor = bisque1, group = 1 ];\n\t";
                // subCadenaU = "U"+nodo.getAbajo().getPosY();
                recorrerFila(nodo.getAbajo());
            }

        } else {
            if (nodo.getAbajo() != null) {
                cadena += "U" + nodo.getAbajo().hashCode() + " [label = \"" + nodo.getAbajo().getPosX() + "," + nodo.getAbajo().getPosY() + "\" width = 1.5 style = filled, fillcolor = bisque1, group = 1 ];\n\t";
                // subCadenaU = " ;U"+nodo.getAbajo().getPosY();
                recorrerFila(nodo.getAbajo());
            }
        }

    }

    private void recorrerColumna(NodoM<T> nodo) {
        //NodoM<T> aux = root.getAbajo();

        if (nodo == root) {

            if (nodo.getDerecha() != null) {
                cadena += "A" + nodo.getDerecha().hashCode() + " [label =\"" + nodo.getDerecha().getPosX() + "," + nodo.getDerecha().getPosY() + "\" width = 1.5 style = filled, fillcolor = lightskyblue, group = " + nodo.getDerecha().getPosX() + "  ];\n\t";
                subCadenaA = "A" + nodo.getDerecha().hashCode();

                recorrerColumna(nodo.getDerecha());
            }

        } else {
            if (nodo.getDerecha() != null) {
                cadena += "A" + nodo.getDerecha().hashCode() + " [label =\"" + nodo.getDerecha().getPosX() + "," + nodo.getDerecha().getPosY() + "\" width = 1.5 style = filled, fillcolor = lightskyblue, group = " + nodo.getDerecha().getPosX() + "  ];\n\t";
                subCadenaA += " ;A" + nodo.getDerecha().hashCode();

                recorrerColumna(nodo.getDerecha());
            }
        }

    }

    private void enlazarFilas(NodoM<T> nodo) {

        if (nodo.getAbajo() != null) {
            if (!(nodo == root)) {
                cadena += "U" + nodo.hashCode() + " ->" + "U" + nodo.getAbajo().hashCode() + ";\n\t";
            }

            enlazarFilas(nodo.getAbajo());
        }

    }

    private void enlazarColumna(NodoM<T> nodo) {

        if (nodo.getDerecha() != null) {
            if (!(nodo == root)) {
                cadena += "A" + nodo.hashCode() + " ->" + "A" + nodo.getDerecha().hashCode() + ";\n\t";
            }

            enlazarColumna(nodo.getDerecha());
        }

    }

    public String mostrarCadena() {
        resetCadena();
        recorrerFila(root);
        enlazarFilas(root);
        cadena += "\n\t";
        recorrerColumna(root);
        enlazarColumna(root);
        if (root.getAbajo() != null) {
            cadena += "Mt -> U" + root.getAbajo().hashCode() + ";\n\t"
                    + "Mt -> A" + root.getDerecha().hashCode() + ";\n\t";
            cadena += "{rank = same; Mt;" + subCadenaA + "}\n\t";
            recorrerNodosDentro(root.getAbajo());
        }
        cadena += "\n\t";

        cadena += "\n}";

        System.out.println(cadena);
        return cadena;
    }

    public void recorrerNodosDentro(NodoM<T> nodoFila) {

        NodoM<T> temp = nodoFila;
        String linkInternos = "";
        System.out.println("NodoFila : " + nodoFila.getPosX() + "," + nodoFila.getPosY());
        String grupo = " U" + temp.hashCode();

        while (temp.getDerecha() != null) {

            cadena += "\n\ti" + temp.getDerecha().hashCode() + "[label = \"" + temp.getDerecha().getValue().toString() + "\" width = 1.5, group = " + temp.getDerecha().getPosX() + " ];\n\t";

            if (temp != nodoFila) {
                //linkInternos += "i" + temp.hashCode() + " -> " + "i" + temp.getDerecha().hashCode() + ";\n\t";
                linkInternos += "i" + temp.getDerecha().hashCode() + " -> " + "i" + temp.getDerecha().getIzquierda().hashCode() + ";\n\t";
            } else {
                linkInternos += "U" + temp.hashCode() + " -> " + "i" + temp.getDerecha().hashCode() + ";\n\t";
                linkInternos += "i" + temp.getDerecha().hashCode() + " -> " + "U" + temp.getDerecha().getIzquierda().hashCode() + ";\n\t";
            }

            if (temp.getDerecha().getArriba().getPosY() == 0) {
                linkInternos += "i" + temp.getDerecha().hashCode() + " -> " + "A" + temp.getDerecha().getArriba().hashCode() + ";\n\t";
                linkInternos += "A" + temp.getDerecha().getArriba().hashCode() + " -> " + "i" + temp.getDerecha().hashCode() + ";\n\t";
            } else {
                linkInternos += "i" + temp.getDerecha().hashCode() + " -> " + "i" + temp.getDerecha().getArriba().hashCode() + ";\n\t";
            }
            if (temp.getDerecha().getAbajo() != null) {
                linkInternos += "i" + temp.getDerecha().hashCode() + " -> " + "i" + temp.getDerecha().getAbajo().hashCode() + ";\n\t";
            }
            if (temp.getDerecha().getDerecha() != null) {
                linkInternos += "i" + temp.getDerecha().hashCode() + " -> " + "i" + temp.getDerecha().getDerecha().hashCode() + ";\n\t";
            }

            grupo += "; i" + temp.getDerecha().hashCode();

            temp = temp.getDerecha();
        }
        cadena += "\n\t" + linkInternos + "\n\t{ rank = same; " + grupo + ";}\n\t";

        //internos.add(linkInternos);
        if (nodoFila.getAbajo() != null) {

            recorrerNodosDentro(nodoFila.getAbajo());

        }
    }

    public NodoM<T> getColumnaNodo(int columna, boolean flag) {

        NodoM<T> aux = root.getDerecha();

        while (aux != null) {

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

    public NodoM<T> triangular(int columna, int fila) {

        NodoM<T> nodoColumna = getColumnaNodo(columna, false);
        if (nodoColumna != null) {
            NodoM<T> aux = nodoColumna;

            while (aux != null) {
                if (aux.getPosY() == fila) {
                    return aux;
                }
                aux = aux.getAbajo();
            }
        }
        return null;
    }

    public void insertar(int columna, int fila, T value) {
        NodoM<T> nuevo = new NodoM<>(fila, columna, value);

        //  System.out.println("["+fila+","+columna+"]");
        this.insertar(nuevo);

    }

    public void insertar(NodoM<T> nuevo) {
        int fila = nuevo.getPosY();
        int columna = nuevo.getPosX();

        NodoM<T> initFila = getFilaNodo(fila, true);
        NodoM<T> inicioColumna = getColumnaNodo(columna, true);

        NodoM<T> cabeza = inicioColumna.getAbajo();

        if (cabeza == null) {
            inicioColumna.setAbajo(nuevo);
            nuevo.setArriba(inicioColumna);
        } else {
            if (cabeza.getPosY() > fila) {

                nuevo.setAbajo(cabeza);
                cabeza.setArriba(nuevo);
                inicioColumna.setAbajo(nuevo);
                nuevo.setArriba(inicioColumna);

            } else {
                NodoM<T> aux = cabeza;
                boolean insertado = false;

                while (aux.getAbajo() != null) {

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
        } else {

            if (cabeza.getPosX() > columna) {
                nuevo.setDerecha(cabeza);
                cabeza.setIzquierda(nuevo);
                initFila.setDerecha(nuevo);
                nuevo.setIzquierda(initFila);
            } else {
                NodoM<T> aux = cabeza;
                boolean insertado = false;

                while (aux.getDerecha() != null) {

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

  

    public void dibujar(String direccionDot, String direccionPng) {
        try {
            ProcessBuilder pbuilder;

            /*
			 * Realiza la construccion del comando    
			 * en la linea de comandos esto es: 
			 * dot -Tpng -o archivo.png archivo.dot
             */
            pbuilder = new ProcessBuilder("dot", "-Tpng", "-o", direccionPng, direccionDot);
            pbuilder.redirectErrorStream(true);
            //Ejecuta el proceso
            pbuilder.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
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
        final Capa<?> other = (Capa<?>) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
