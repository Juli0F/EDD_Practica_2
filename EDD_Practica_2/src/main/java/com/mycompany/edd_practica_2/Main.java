/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd_practica_2;

import com.mycompany.edd_practica_2.arbol.Arbol;
import com.mycompany.edd_practica_2.io.WriteFile;
import com.mycompany.edd_practica_2.listas.ListaDoble;
import com.mycompany.edd_practica_2.listas.LstCircular;
import com.mycompany.edd_practica_2.matriz_dispersa.Capa;
import com.mycompany.edd_practica_2.usuario.Usuario;
import java.util.Random;

/**
 *
 * @author Temporal
 */
public class Main {

    public static void main(String[] args) {

      //  pruebaListaDoble();
       pruebaMatrizDispersa();
    //  pruebaListaCircular();
        pruebaArbol();
       // Arbol<Matriz> capas = new Arbol<>();
        
        
    }
    public static void pruebaListaCircular(){
        LstCircular<Usuario> lstDoble = new LstCircular<>();
        
        String usr  = "# ";
        boolean insert = false;
        for (int i = 0; i < 10; i++) {
            Usuario usuario = new Usuario();
            usuario.setUsuario(usr + i);
            
                lstDoble.insertar(usuario);    
            
        
        }
        
        //lstDoble.mostrar();
        System.out.println("graph");
        //lstDoble.recorrerLstGraph();
        lstDoble.recorrerLstGraph();
        
    }
    public static String generarColor(){
        String[] letters = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
	String color = "#";
	for (int i = 0; i < 6; i++ ) {
	    color += letters[(int) Math.round(Math.random() * 15)];
	}
        return color;
    }

    public static void pruebaMatrizDispersa() {
        Capa<String> dispersa = new Capa<String>(1);
        String usr = "Julio - ";

        
        
        for (int i = 0; i < 10; i++) {
            Usuario usuario = new Usuario();
            usuario.setUsuario(usr + i);
            
                dispersa.insertar(i+1, i+1,generarColor());    
            
            
        
        }
       
       
        dispersa.insertar(1,10,"1-10");
        dispersa.insertar(10,6,"10-6");
        
        
        String cadena = dispersa.mostrarCadena();
        WriteFile wf = new WriteFile();
        
        wf.writeFile("matriz.dot", cadena);
        dispersa.dibujar("matriz.dot", "matriz.png");
       // System.out.println(dispersa.toString());

    }

    public static void pruebaListaDoble() {
        ListaDoble<Usuario> lstUsuario = new ListaDoble<Usuario>();

        String usr = "Julio - ";

        for (int i = 0; i < 10; i++) {
            Usuario usuario = new Usuario();
            usuario.setUsuario(usr + i);
            lstUsuario.insertar(usuario);

        }

        lstUsuario.imprimir();
        lstUsuario.recorrerLstGraph();
    }

    public static void pruebaArbol() {
        Arbol arbol = new Arbol(null);
//        
//        arbol.insertar(3, "nodo prueba");
//        arbol.insertar(1, "nodo prueba");
//        arbol.insertar(2, "nodo prueba 2");

        Random rand = new Random();

        for (int i = 0; i < 10; i++) {

            int indice = rand.nextInt(100);
            System.out.println("indice " + indice);
            arbol.insertar(indice, "nodo " + 1);

        }

        
        System.out.println("In orden");
        arbol.graphInOrden("Arbol-prueba.dot", "In-Orden.png");
        
        System.out.println("pre Or");
        arbol.graphPreOrden();
        
        System.out.println("Post");
        arbol.graphPostOrden();

    }
}
