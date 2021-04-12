package prueba;

import com.mycompany.edd_practica_2.io.WriteFile;
import com.mycompany.edd_practica_2.matriz_dispersa.Capa;
import com.mycompany.edd_practica_2.usuario.Usuario;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size(root);
    }

    private int size(Nodo<T> x) {
        if (x == null) {
            return 0;
        }
        return x.size;
    }

    public int height() {
        return height(root);
    }

    private int height(Nodo<T> x) {
        if (x == null) {
            return -1;
        }
        return x.height;
    }

    public void put(T val) {
        root = put(root, val);
    }

    public Nodo<T> find(T val, Nodo<T> x) {
        if (x == null) {
            return null;
        }

        if (x.value.hashCode() == val.hashCode()) {
            System.out.println("encontrado");
            return x;
        } else if (val.hashCode() < x.value.hashCode()) {
            return find(val, x.left);
        } else {
            return find(val, x.right);
        }
    }

    private Nodo<T> put(Nodo<T> x, T val) {
        System.out.println("Insertando valor");
        if (x == null) {
            return new Nodo(val, 0, 1);
        }

        if (val.hashCode() < x.value.hashCode()) {

            x.left = put(x.left, val);

        } else if (val.hashCode() > x.value.hashCode()) {
            x.right = put(x.right, val);
        } else {
            x.value = val;
            System.out.println("Insertando valor insertado");
            return x;
        }
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return balance(x);
    }

    private Nodo<T> balance(Nodo<T> x) {
        if (balanceFactor(x) > 1) {
            if (balanceFactor(x.right) < 0) {
                x.right = rotacionAlaDerecha(x.right);
            }
            x = rotateLeft(x);
        } else if (balanceFactor(x) < -1) {
            if (balanceFactor(x.left) > 0) {
                x.left = rotateLeft(x.left);
            }
            x = rotacionAlaDerecha(x);
        }
        return x;
    }

    private int balanceFactor(Nodo<T> x) {
        return height(x.right) - height(x.left);
    }

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

    public void delete(T val) {
        root = delete(root, val);
    }

    private Nodo<T> delete(Nodo<T> x, T val) {
        if (val.hashCode() < x.value.hashCode()) {
            x.left = delete(x.left, val);
        } else if (val.hashCode() > x.value.hashCode()) {
            x.right = delete(x.right, val);
        } else {
            if (x.left == null) {
                return x.right;
            } else if (x.right == null) {
                return x.left;
            } else {
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

    private Nodo<T> deleteMin(Nodo<T> x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return balance(x);
    }

    private Nodo min(Nodo<T> x) {
        if (x.left == null) {
            return x;
        }
        return min(x.left);
    }

    public DefaultTableModel inOrden(Nodo<T> n, DefaultTableModel dtableModel) {
        if (n != null) {
            inOrden(n.left, dtableModel);

            System.out.print(n.value + ", ");
            if (n.getValue() instanceof Capa) {
                Capa<String> capaValue = (Capa<String>) n.value;
                
             //   System.out.println(capaValue);
                dtableModel.addRow(new Object[]{
                    "Capa :" + capaValue.getId()
                });
            } else {
                Usuario d = (Usuario) n.value;
               
                System.out.println(d.getUsuario());
                dtableModel.addRow(new Object[]{
                    d.getUsuario()
                });
            }

            inOrden(n.right, dtableModel);
        }
        return dtableModel;

    }

    private void resetCadena() {
        cadena = "digraph Figura{\n\t";
    }

    private void graphArbol(Nodo<T> n) {
        if (n != null) {

            graphArbol(n.left);

            if (n.left != null) {

                if (n.getValue() instanceof Capa) {
                    Capa<String> d = (Capa<String>) n.value;
                    Capa<String> e = (Capa<String>) n.left.value;
                    cadena += d.getId() + " ->" + e.getId() + ";\n\t";;
                } else {
                    Usuario d = (Usuario) n.value;
                    Usuario e = (Usuario) n.left.value;
                    cadena += d.getUsuario() + " ->" + e.getUsuario() + ";\n\t";;
                }

            }

            if (n.right != null) {
                if (n.getValue() instanceof Capa) {
                    Capa<String> d = (Capa<String>) n.value;
                    Capa<String> e = (Capa<String>) n.right.value;
                    cadena += d.getId() + " ->" + e.getId() + ";\n\t";
                } else {

                    Usuario d = (Usuario) n.value;
                    Usuario e = (Usuario) n.right.value;
                    cadena += d.getUsuario() + " ->" + e.getUsuario() + ";\n\t";;
                }

            }

            graphArbol(n.right);
        }
    }

    private void graphPre(Nodo<T> n) {
        if (n != null) {
            if (n.left != null) {

                if (n.getValue() instanceof Capa) {
                    Capa<String> d = (Capa<String>) n.value;
                    Capa<String> e = (Capa<String>) n.left.value;
                    cadena += d.getId() + " ->" + e.getId() + ";\n\t";;
                } else {
                    Usuario d = (Usuario) n.value;
                    Usuario e = (Usuario) n.left.value;
                    cadena += d.getUsuario() + " ->" + e.getUsuario() + ";\n\t";;
                }

            }

            if (n.right != null) {
                if (n.getValue() instanceof Capa) {
                    Capa<String> d = (Capa<String>) n.value;
                    Capa<String> e = (Capa<String>) n.right.value;
                    cadena += d.getId() + " ->" + e.getId() + ";\n\t";
                } else {

                    Usuario d = (Usuario) n.value;
                    Usuario e = (Usuario) n.right.value;
                    cadena += d.getUsuario() + " ->" + e.getUsuario() + ";\n\t";;
                }

            }

            graphPre(n.left);
            graphPre(n.right);
        }
    }

    private void graphPost(Nodo<T> n) {
        if (n != null) {
            graphPost(n.left);
            graphPost(n.right);

            if (n.left != null) {

                if (n.getValue() instanceof Capa) {
                    Capa<String> d = (Capa<String>) n.value;
                    Capa<String> e = (Capa<String>) n.left.value;
                    cadena += d.getId() + " ->" + e.getId() + ";\n\t";;
                } else {
                    Usuario d = (Usuario) n.value;
                    Usuario e = (Usuario) n.left.value;
                    cadena += d.getUsuario() + " ->" + e.getUsuario() + ";\n\t";;
                }

            }

            if (n.right != null) {
                if (n.getValue() instanceof Capa) {
                    Capa<String> d = (Capa<String>) n.value;
                    Capa<String> e = (Capa<String>) n.right.value;
                    cadena += d.getId() + " ->" + e.getId() + ";\n\t";
                } else {

                    Usuario d = (Usuario) n.value;
                    Usuario e = (Usuario) n.right.value;
                    cadena += d.getUsuario() + " ->" + e.getUsuario() + ";\n\t";;
                }

            }

        }
    }

    public void graphInOrden(String nombreDot, String nombrePng) {
        resetCadena();
        System.out.println("\ncadena = " + cadena);
        graphArbol(root);
        cadena += "\n}";
        System.out.println("\n" + cadena);
        WriteFile wf = new WriteFile();
        wf.writeFile(nombreDot, cadena);
        wf.dibujar(nombreDot, nombrePng);
    }

    public void graphPre(String nombreDot, String nombrePng) {
        resetCadena();
        System.out.println("\ncadena = " + cadena);
        graphPre(root);
        cadena += "\n}";
        System.out.println("\n" + cadena);
        WriteFile wf = new WriteFile();
        wf.writeFile(nombreDot, cadena);
        wf.dibujar(nombreDot, nombrePng);
    }

    public void graphPost(String nombreDot, String nombrePng) {
        resetCadena();
        System.out.println("\ncadena = " + cadena);
        graphPost(root);
        cadena += "\n}";
        System.out.println("\n" + cadena);
        WriteFile wf = new WriteFile();
        wf.writeFile(nombreDot, cadena);
        wf.dibujar(nombreDot, nombrePng);
    }

    /**
     * Recorre el árbol en PreOrden: R - I - D
     *
     * @param n
     */
    public DefaultTableModel preOrden(Nodo<T> n, DefaultTableModel dtableModel) {
        if (n != null) {
            System.out.print(n.value + ", ");
            if (n.left != null) {
                if (n.getValue() instanceof Capa) {
                    Capa<String> d = (Capa<String>) n.value;
                    Capa<String> e = (Capa<String>) n.left.value;
                    
                    dtableModel.addRow(new Object[]{
                        "Capa :" + d.getId()
                    });
                } else {
                    Usuario d = (Usuario) n.value;
                    
                    System.out.println(d.getUsuario());
                    dtableModel.addRow(new Object[]{
                        d.getUsuario()
                    });
                }
            }

            if (n.right != null) {
                if (n.getValue() instanceof Capa) {
                    Capa<String> d = (Capa<String>) n.value;
                    Capa<String> e = (Capa<String>) n.right.value;
                    
                    dtableModel.addRow(new Object[]{
                        "Capa :" + d.getId()
                    });
                } else {
                    Usuario d = (Usuario) n.value;
                    
                    System.out.println(d.getUsuario());
                    dtableModel.addRow(new Object[]{
                        d.getUsuario()
                    });
                }
            }

            preOrden(n.left, dtableModel);
            preOrden(n.right, dtableModel);
        }
        return dtableModel;
    }

    /**
     * Recorre el árbol en PostOrden: I - D - R
     *
     * @param n
     */
    public DefaultTableModel postOrden(Nodo<T> n, DefaultTableModel dtableModel) {
        if (n != null) {
            postOrden(n.left, dtableModel);
            postOrden(n.right, dtableModel);

            if (n.left != null) {
                if (n.getValue() instanceof Capa) {
                    Capa<String> d = (Capa<String>) n.value;
                    Capa<String> e = (Capa<String>) n.left.value;
                    cadena += d.getId() + " ->" + e.getId() + ";\n\t";;
                    dtableModel.addRow(new Object[]{
                        "Capa :" + d.getId()
                    });
                } else {
                    Usuario d = (Usuario) n.value;
                    Usuario e = (Usuario) n.value;
                    System.out.println(e.getUsuario());
                    dtableModel.addRow(new Object[]{
                        d.getUsuario(),e.getUsuario()
                    });
                }
            }

            if (n.right != null) {
                if (n.getValue() instanceof Capa) {
                    Capa<String> d = (Capa<String>) n.value;
                    Capa<String> e = (Capa<String>) n.right.value;
                    cadena += d.getId() + " ->" + e.getId() + ";\n\t";;
                    dtableModel.addRow(new Object[]{
                        "Capa :" + d.getId()
                    });
                } else {
                    Usuario d = (Usuario) n.value;
                    Usuario e = (Usuario) n.right.value;
                    System.out.println(d.getUsuario());
                    dtableModel.addRow(new Object[]{
                        d.getUsuario(),e.getUsuario()
                    });
                }
            }

            
        }
        return dtableModel;
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
