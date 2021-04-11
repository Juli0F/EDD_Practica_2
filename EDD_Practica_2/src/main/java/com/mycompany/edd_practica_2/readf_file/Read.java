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
import javax.swing.JTextArea;

/**
 *
 * @author Temporal
 */
public class Read {

    public void leerTexto(File file) {

    }

    public void leerTexto(String path) {

        Interprete interprete = new Interprete();
        System.out.println("path " + path);
        String fileStr = "";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String linea = br.readLine();

            while (linea != null) {

                System.out.println(linea);

                linea = br.readLine();
                fileStr += linea;
            }

            if (path.contains(".cap")) {
                interprete.interpreteCapa(fileStr);
            } else if (path.contains(".im")) {
                interprete.interpreteImg(fileStr);
            } else if (path.contains(".usr")) {
                interprete.interpreteUsr(fileStr);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void leerTexto(String path, JTextArea area) {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String linea = br.readLine();
            Interprete interprete = new Interprete();

            while (linea != null) {

                area.setText(area.getText() + "\n" + linea);
                linea = br.readLine();

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
