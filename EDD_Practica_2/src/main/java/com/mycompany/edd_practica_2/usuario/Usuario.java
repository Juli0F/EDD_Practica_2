/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd_practica_2.usuario;

import com.mycompany.edd_practica_2.Imagen;
import com.mycompany.edd_practica_2.listas.ListaDoble;
import java.util.Objects;

/**
 *
 * @author Temporal
 */
public class Usuario {
    
    private String usuario;
    private ListaDoble<Imagen> imgs;
    private ListaDoble<Integer> imgsInt;

    public Usuario() {
        imgs =new ListaDoble<>();
        imgsInt =new ListaDoble<>();
    }

    
    public ListaDoble<Integer> getImgsInt() {
        return imgsInt;
    }

    public void setImgsInt(ListaDoble<Integer> imgsInt) {
        this.imgsInt = imgsInt;
    }
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public ListaDoble<Imagen> getImgs() {
        return imgs;
    }

    public void setImgs(ListaDoble<Imagen> imgs) {
        this.imgs = imgs;
    }
    

    @Override
    public String toString() {
        return " {" + "idUsuario =" + this.usuario + '}';
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.usuario);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
