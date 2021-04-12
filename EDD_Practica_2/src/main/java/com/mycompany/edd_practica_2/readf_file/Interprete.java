/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd_practica_2.readf_file;

import com.mycompany.edd_practica_2.CapaLoad;
import com.mycompany.edd_practica_2.Imagen;
import com.mycompany.edd_practica_2.ImgLoad;
import com.mycompany.edd_practica_2.Lexer_Capas;
import com.mycompany.edd_practica_2.UsrLoad;
import com.mycompany.edd_practica_2.matriz_dispersa.Capa;
import com.mycompany.edd_practica_2.parser;
import com.mycompany.edd_practica_2.parser_img.Parser_ImgLoad;
import com.mycompany.edd_practica_2.parser_usr.Lexer_Usuario;
import com.mycompany.edd_practica_2.parser_usr.Parser_Usuario;
import com.mycompany.edd_practica_2.ui.Frame;
import com.mycompany.edd_practica_2.usuario.Usuario;
import java.io.StringReader;
import java.util.List;
import java_cup.runtime.Symbol;
import prueba.Arbol;
import prueba.Nodo;

/**
 *
 * @author Temporal
 */
public class Interprete {
   

    public Interprete() {
//        capas = new Arbol<Capa<String>>();
//        arbolUsr = new Arbol<Usuario>();
//        lstCircular = new LstCircular<>();
    }
    

    public void interpreteCapa(String linea) throws Exception {
        System.out.println("capas");
        Lexer_Capas lexer = new Lexer_Capas(new StringReader(linea));

        parser p = new parser(lexer);

        Symbol s = p.parse();
        List<CapaLoad> crear = (List<CapaLoad>) s.value;
        
        int id = 0;
        Capa<String> capa = null;
        for (CapaLoad c : crear) {

            if (c.getId() != id) {
                 capa = new Capa<>(c.getId());
                 //capas.insertar(c.getId(), capa);
                 Frame.capas.put(capa);
                id = c.getId();     
            }
                capa.insertar(c.getFila(), c.getColumna(), c.getColor());

        }

    }

    public void interpreteImg(String linea) throws Exception {
            Lexer_Capas lexer = new Lexer_Capas(new StringReader(linea));
            Parser_ImgLoad parser = new Parser_ImgLoad(lexer);
             Symbol s = parser.parse();
             List<ImgLoad> crear = (List<ImgLoad>) s.value;
             
             
             crear.forEach(x->{
                 
                Imagen im = new Imagen(x.getIdImagen());                 
                 x.getCapas().forEach(cp ->{
                     Capa<String> cx = new Capa<>(cp);
                        Nodo<Capa<String>> nodo = Frame.capas.find(cx,Frame.capas.getRoot());
                        System.out.println("Nodo ==> "+ nodo.toString());
                     if (nodo != null) {
                         im.getCapas().insertar(nodo.getValue());    
                    }
//                     
                 });
                 
                 Frame.lstCircular.insertar(im);
                     
                 
                 
             });
             
            
             
             
    }

    public void interpreteUsr(String linea) throws Exception {
            Lexer_Usuario lexerUsr = new Lexer_Usuario(new StringReader(linea));
            Parser_Usuario parser = new Parser_Usuario(lexerUsr);
             Symbol s = parser.parse();
             List<UsrLoad> crear = (List<UsrLoad>) s.value;
              
             crear.forEach(x -> {
                 Usuario usuario = new Usuario();
                 usuario.setUsuario(x.getId());
                 x.getLst().forEach( b -> {
                     
                     System.out.println("list "+b);
                  //   com.mycompany.edd_practica_2.listas.Nodo<Imagen> node = Frame.lstCircular.buscar((b));
                     usuario.getImgsInt().insertar(b);
                     
                     
//                     
//                     node.setSiguiente(null);
//                     if (node != null) {
//                         usuario.getImgs().insertar(node);
//                         
//                     }
                 });
                 
                 Frame.arbolUsr.put( usuario);
                 
             });
            
    }
}
