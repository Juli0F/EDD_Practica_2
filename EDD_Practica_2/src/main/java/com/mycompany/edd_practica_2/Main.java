/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd_practica_2;

import com.mycompany.edd_practica_2.arbol.Arbol;
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

        //pruebaListaDoble();
      //  pruebaMatrizDispersa();
      pruebaListaCircular();
        
       // Arbol<Matriz> capas = new Arbol<>();
        
        
    }
    public static void pruebaListaCircular(){
        LstCircular<Usuario> lstDoble = new LstCircular<>();
        
        String usr  = "Julio - ";
        boolean insert = false;
        for (int i = 0; i < 10; i++) {
            Usuario usuario = new Usuario();
            usuario.setUsuario(usr + i);
            
                lstDoble.insertar(usuario);    
            
        
        }
        
        lstDoble.mostrar();
        
    }

    public static void pruebaMatrizDispersa() {
        Capa<Usuario> dispersa = new Capa<Usuario>(1);
        String usr = "Julio - ";

        boolean insert = false;
        for (int i = 0; i < 10; i++) {
            Usuario usuario = new Usuario();
            usuario.setUsuario(usr + i);
            if (insert) {
                dispersa.insertar(i, i+1,usuario);    
            }else{
                dispersa.insertar(i+1, i,usuario);    
            }
            
            insert = !insert;
        
        }
        
        dispersa.imprimir();
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
    }

    public void pruebaArbol() {
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

        System.out.println("\nPreOrder");
        for (int i = 0; i < 10; i++) {
            System.out.print("____");

        }
        System.out.println("");
        arbol.preOrden(arbol.getRoot());

        System.out.println("\nEn orden");
        for (int i = 0; i < 10; i++) {
            System.out.print("____");

        }
        System.out.println("");
        arbol.inOrden(arbol.getRoot());

        System.out.println("\nPostOrder");
        for (int i = 0; i < 10; i++) {
            System.out.print("____");

        }
        System.out.println("");
        arbol.postOrden(arbol.getRoot());

    }
}
