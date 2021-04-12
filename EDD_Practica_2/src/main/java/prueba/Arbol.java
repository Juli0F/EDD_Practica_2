package prueba;

import com.mycompany.edd_practica_2.io.WriteFile;
import com.mycompany.edd_practica_2.matriz_dispersa.Capa;
import com.mycompany.edd_practica_2.usuario.Usuario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jesus
 */
public class Arbol<T> {
     protected Nodo<T> root;
     private String cadena;
     private int contador = 0;
    
    /**
     * Checks if the tree is empty.
     * 
     * @return {@code true} if the tree is empty.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Returns the number of nodes.
     * 
     * @return the number of nodes.
     */
    public int size() {
        return size(root);
    }

    /**
     * Returns the number of nodes in the subtree.
     * 
     * @param x the subtree
     * 
     * @return the number of nodes in the subtree
     */
    private int size(Nodo<T> x) {
        if (x == null) return 0;
        return x.size;
    }

    /**
     * Returns the height of the internal AVL tree. It is assumed that the
     * height of an empty tree is -1 and the height of a tree with just one node
     * is 0.
     * 
     * @return the height of the internal AVL tree
     */
    public int height() {
        return height(root);
    }

    /**
     * Returns the height of the subtree.
     * 
     * @param x the subtree
     * 
     * @return the height of the subtree.
     */
    private int height(Nodo<T> x) {
        if (x == null) return -1;
        return x.height;
    }

     /**
     * Inserts the specified value in the tree
     * 
     * @param val the value
     */
    public void put(T val) {
        root = put(root, val);
    }
    
    /**
     * Recorre el árbol para encontrar un valor, devolviendo su nodo o null si no
     * lo encuentra
     * @param val
     * @param x
     * @return 
     */
    public Nodo<T> find(T val, Nodo<T> x)
    {
        if (x==null)
        {
            return null;
        }
        
        if (x.value.hashCode()==val.hashCode())
        {
            System.out.println("encontrado");
            return x;
        }
        else if (val.hashCode() < x.value.hashCode())
        {
            return find(val,x.left);
        }
        else
        {
            return find(val,x.right);
        }
    }

    /**
     * Inserts the value in the subtree. 
     * @param x the subtree
     * @param val the value
     * @return the subtree
     */
    private Nodo<T> put(Nodo<T> x, T val) {
        System.out.println("Insertando valor");
        if (x == null) return new Nodo(val, 0, 1);
        
        if (val.hashCode() < x.value.hashCode()) {
            
            x.left = put(x.left, val);
            
        }
        else if (val.hashCode() > x.value.hashCode()) {
            x.right = put(x.right, val);
        }
        else {
            x.value = val;
            System.out.println("Insertando valor insertado");
            return x;
        }
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return balance(x);
    }

    /**
     * Restores the AVL tree property of the subtree.
     * 
     * @param x the subtree
     * @return the subtree with restored AVL property
     */
    private Nodo<T> balance(Nodo<T> x) {
        if (balanceFactor(x) > 1) {
            if (balanceFactor(x.right) < 0) {
                x.right = rotacionAlaDerecha(x.right);
            }
            x = rotateLeft(x);
        }
        else if (balanceFactor(x) < -1) {
            if (balanceFactor(x.left) > 0) {
                x.left = rotateLeft(x.left);
            }
            x = rotacionAlaDerecha(x);
        }
        return x;
    }

    /**
     * Returns the balance factor of the subtree. The balance factor is defined
     * as the difference in height of the left subtree and right subtree, in
     * this order. Therefore, a subtree with a balance factor of -1, 0 or 1 has
     * the AVL property since the heights of the two child subtrees differ by at
     * most one.
     * 
     * @param x the subtree
     * @return the balance factor of the subtree
     */
    private int balanceFactor(Nodo<T> x) {
        return height(x.right) - height(x.left);
    }

    /**
     * Rotates the given subtree to the right.
     * 
     * @param x the subtree
     * @return the right rotated subtree
     */
    private Nodo<T> rotacionAlaDerecha(Nodo<T> x) {
        Nodo y = x.left;
        x.left = y.right;
        y.right = x;
        y.size = x.size;
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        return y;
    }

    /**
     * Rotates the given subtree to the left.
     * 
     * @param x the subtree
     * @return the left rotated subtree
     */
    private Nodo<T> rotateLeft(Nodo<T> x) {
        Nodo<T> y = x.right;
        x.right = y.left;
        y.left = x;
        y.size = x.size;
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        return y;
    }

    /**
     * Removes the specified value and its associated node
     * @param val the value
     */
    public void delete(T val) {
        root = delete(root, val);
    }

    /**
     * Removes the specified value and its associated node from the given
     * subtree.
     * 
     * @param x the subtree
     * @param val the value
     * @return the updated subtree
     */
    private Nodo<T> delete(Nodo<T> x, T val) {
        if (val.hashCode() < x.value.hashCode()) {
            x.left = delete(x.left, val);
        }
        else if (val.hashCode() > x.value.hashCode()) {
            x.right = delete(x.right, val);
        }
        else {
            if (x.left == null) {
                return x.right;
            }
            else if (x.right == null) {
                return x.left;
            }
            else {
                Nodo y = x;
                x = min(y.right);
                x.right = deleteMin(y.right);
                x.left = y.left;
            }
        }
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return balance(x);
    }  
     
    /**
     * Removes the smallest node from the given subtree.
     * 
     * @param x the subtree
     * @return the updated subtree
     */
    private Nodo<T> deleteMin(Nodo<T> x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return balance(x);
    }
    
    /**
     *regresa el nodo peque;o, una hoja
     * 
     * @param x the subtree
     * @return the node with the smallest key in the subtree
     */
    private Nodo min(Nodo<T> x) {
        if (x.left == null) return x;
        return min(x.left);
    }
    
    /**
     * Recorre el árbol en InOrden: I - R - D
     * @param n 
     */
    public void inOrden(Nodo<T> n)
    {
        if (n!=null)
        {
            inOrden(n.left);
            
            System.out.print(n.value + ", ");
            inOrden(n.right);
        }
    }
    private void resetCadena(){
        cadena ="digraph Figura{\n\t";
    }
    private void graphArbol(Nodo<T> n)
    {
        if (n!=null)
        {
            
            graphArbol(n.left);
                    
            if (n.left != null) {
               
                if (n.getValue() instanceof Capa) {
                    Capa<String> d = (Capa<String>) n.value;
                    Capa<String> e = (Capa<String>) n.left.value;
                    cadena += d.getId() +" ->" + e.getId()+";\n\t";;
                }else{
                    Usuario d =(Usuario)n.value;
                    Usuario e =(Usuario)n.left.value;
                    cadena += d.getUsuario() +" ->" + e.getUsuario()+";\n\t";;
                }
                
            }
            
            if (n.right != null) {
                if (n.getValue() instanceof Capa) {
                    Capa<String> d = (Capa<String>) n.value;
                    Capa<String> e = (Capa<String>) n.right.value;
                    cadena += d.getId() +" ->" + e.getId()+";\n\t";
                }else{
                    
                    Usuario d =(Usuario)n.value;
                    Usuario e =(Usuario)n.right.value;
                    cadena += d.getUsuario() +" ->" + e.getUsuario()+";\n\t";;
                }
                
            }
            
            graphArbol(n.right);
        }
    }
    private void graphPre(Nodo<T> n)
    {
        if (n!=null)
        {
            
            
                    
            if (n.left != null) {
               
                if (n.getValue() instanceof Capa) {
                    Capa<String> d = (Capa<String>) n.value;
                    Capa<String> e = (Capa<String>) n.left.value;
                    cadena += d.getId() +" ->" + e.getId()+";\n\t";;
                }else{
                    Usuario d =(Usuario)n.value;
                    Usuario e =(Usuario)n.left.value;
                    cadena += d.getUsuario() +" ->" + e.getUsuario()+";\n\t";;
                }
                
            }
            
            if (n.right != null) {
                if (n.getValue() instanceof Capa) {
                    Capa<String> d = (Capa<String>) n.value;
                    Capa<String> e = (Capa<String>) n.right.value;
                    cadena += d.getId() +" ->" + e.getId()+";\n\t";
                }else{
                    
                    Usuario d =(Usuario)n.value;
                    Usuario e =(Usuario)n.right.value;
                    cadena += d.getUsuario() +" ->" + e.getUsuario()+";\n\t";;
                }
                
            }
            
            graphPre(n.left);
            graphPre(n.right);
        }
    }
    private void graphPost(Nodo<T> n)
    {
        if (n!=null)
        {
            
            
            graphPost(n.left);
            graphPost(n.right);
                    
            if (n.left != null) {
               
                if (n.getValue() instanceof Capa) {
                    Capa<String> d = (Capa<String>) n.value;
                    Capa<String> e = (Capa<String>) n.left.value;
                    cadena += d.getId() +" ->" + e.getId()+";\n\t";;
                }else{
                    Usuario d =(Usuario)n.value;
                    Usuario e =(Usuario)n.left.value;
                    cadena += d.getUsuario() +" ->" + e.getUsuario()+";\n\t";;
                }
                
            }
            
            if (n.right != null) {
                if (n.getValue() instanceof Capa) {
                    Capa<String> d = (Capa<String>) n.value;
                    Capa<String> e = (Capa<String>) n.right.value;
                    cadena += d.getId() +" ->" + e.getId()+";\n\t";
                }else{
                    
                    Usuario d =(Usuario)n.value;
                    Usuario e =(Usuario)n.right.value;
                    cadena += d.getUsuario() +" ->" + e.getUsuario()+";\n\t";;
                }
                
            }
            
        }
    }
    public void graphInOrden(String nombreDot, String nombrePng){
     resetCadena();
        System.out.println("\ncadena = "+cadena);
        graphArbol(root);
        cadena += "\n}";
        System.out.println("\n"+cadena);
        WriteFile wf = new WriteFile();
        wf.writeFile(nombreDot, cadena);
        wf.dibujar(nombreDot, nombrePng);
    }
     public void graphPre(String nombreDot, String nombrePng){
     resetCadena();
        System.out.println("\ncadena = "+cadena);
        graphPre(root);
        cadena += "\n}";
        System.out.println("\n"+cadena);
        WriteFile wf = new WriteFile();
        wf.writeFile(nombreDot, cadena);
        wf.dibujar(nombreDot, nombrePng);
    }
      public void graphPost(String nombreDot, String nombrePng){
     resetCadena();
        System.out.println("\ncadena = "+cadena);
        graphPost(root);
        cadena += "\n}";
        System.out.println("\n"+cadena);
        WriteFile wf = new WriteFile();
        wf.writeFile(nombreDot, cadena);
        wf.dibujar(nombreDot, nombrePng);
    }
    
    /**
     * Recorre el árbol en PreOrden: R - I - D
     * @param n 
     */
    public void preOrden(Nodo<T> n)
    {
        if (n!=null)
        {
            System.out.print(n.value + ", ");
            preOrden(n.left);
            preOrden(n.right);
        }
    }
    
    /**
     * Recorre el árbol en PostOrden: I - D - R
     * @param n 
     */
    public void postOrden(Nodo<T> n)
    {
        if (n!=null)
        {
            postOrden(n.left);
            postOrden(n.right);
            System.out.print(n.value + ", ");
        }
    }

    public Nodo<T> getRoot() {
        return root;
    }

    public void setRoot(Nodo<T> root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "Arbol{" + "cadena=" + cadena + '}';
    }
    
    
    
    
}
