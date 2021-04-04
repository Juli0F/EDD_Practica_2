/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura_acciones;

import com.mycompany.edd_practica_2.exception.InsertException;

/**
 *
 * @author Temporal
 */
public interface Estructura<T> {
    
    public boolean insertar(int id) throws InsertException;
    public boolean observar() throws InsertException;
    public boolean eliminar() ;
    public boolean actualizar();
    
}
