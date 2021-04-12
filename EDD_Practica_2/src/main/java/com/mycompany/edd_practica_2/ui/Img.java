package com.mycompany.edd_practica_2.ui;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
public class Img extends Component{
        /**
         *
         */
      //  private static final long serialVersionUID = 1901784943150215057L;
        BufferedImage log;
         public void paint(Graphics g){
                         g.drawImage(log, 0,0, null);
                 }
                public Img(String nombre){
                        try{
                                log = ImageIO.read(new File(nombre));
                                System.out.println("img cargada");
                        }
                        catch(Exception e){
                                System.out.print("Error en la carga de la imagen");
                                }
                 
                }
}
        