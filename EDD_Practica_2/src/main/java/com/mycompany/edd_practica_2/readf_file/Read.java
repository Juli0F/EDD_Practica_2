/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd_practica_2.readf_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author Temporal
 */
public class Read {

    public void leerTexto(String path) throws FileNotFoundException {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            
            String linea = br.readLine();
            
            while(linea!= null){
                
                linea += br.readLine();
            }
            
        }catch(Exception ex){
            
        }

    }
}
