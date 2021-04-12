/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd_practica_2.ui;


import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Temporal
 */
public class LoadImage extends JPanel {

    private String path;
    public LoadImage(String path) {
        this.setSize(400, 500);
        this.path = path;
    }

    public void paint(Graphics grafico) {
        Dimension height = getSize();
        System.out.println("path "+ path);
        ImageIcon Img = new ImageIcon(path);//(getClass().getResource("Arbol-capas-inorden.png"));
        //System.out.println(getClass().getR);
        
//se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
        grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
        

        setOpaque(false);
        super.paintComponent(grafico);

    }

}
