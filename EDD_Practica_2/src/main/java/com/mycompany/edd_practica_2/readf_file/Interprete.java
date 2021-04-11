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
import com.mycompany.edd_practica_2.arbol.Arbol;
import com.mycompany.edd_practica_2.arbol.Nodo;
import com.mycompany.edd_practica_2.listas.LstCircular;
import com.mycompany.edd_practica_2.matriz_dispersa.Capa;
import com.mycompany.edd_practica_2.parser;
import com.mycompany.edd_practica_2.parser_img.Parser_ImgLoad;
import com.mycompany.edd_practica_2.parser_usr.Lexer_Usuario;
import com.mycompany.edd_practica_2.parser_usr.Parser_Usuario;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import java_cup.runtime.Symbol;

/**
 *
 * @author Temporal
 */
public class Interprete {
    private Arbol<Capa<String>> capas;
    private LstCircular<Imagen> lstCircular ;

    public Interprete() {
        capas = new Arbol<Capa<String>>();
        lstCircular = new LstCircular<>();
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
                 capas.insertar(c.getId(), capa);
            }
                capa.insertar(c.getFila(), c.getColumna(), c.getColor());
           

            id = c.getId();

        }
        capas.graphInOrden();

    }

    public void interpreteImg(String linea) throws Exception {
            Lexer_Capas lexer = new Lexer_Capas(new StringReader(linea));
            Parser_ImgLoad parser = new Parser_ImgLoad(lexer);
             Symbol s = parser.parse();
             List<ImgLoad> crear = (List<ImgLoad>) s.value;
             
             
             crear.forEach(x->{
                 Imagen im = new Imagen(x.getIdImagen());
                 
                 
                 x.getCapas().forEach(cp ->{
                     Nodo<Capa<String>> nodo = capas.buscar(cp, capas.getRoot());
                     if (nodo != null) {
                         im.getCapas().insertar(nodo.getValor());    
                     }
                     
                 });
                 
                 lstCircular.insertar(im);
                     
                 
                 
             });
             
    }

    public void interpreteUsr(String linea) throws Exception {
            Lexer_Usuario lexerUsr = new Lexer_Usuario(new StringReader(linea));
            Parser_Usuario parser = new Parser_Usuario(lexerUsr);
             Symbol s = parser.parse();
             List<UsrLoad> crear = (List<UsrLoad>) s.value;
            
    }
}
