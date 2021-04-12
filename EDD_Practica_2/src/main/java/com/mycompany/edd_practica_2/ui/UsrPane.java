/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.edd_practica_2.ui;

import com.mycompany.edd_practica_2.Imagen;
import com.mycompany.edd_practica_2.io.WriteFile;

import com.mycompany.edd_practica_2.readf_file.Interprete;
import static com.mycompany.edd_practica_2.ui.Frame.paneRoot;
import com.mycompany.edd_practica_2.usuario.Usuario;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Temporal
 */
public class UsrPane extends javax.swing.JPanel {

    /** Creates new form UsrPane */
    public UsrPane() {
        
        initComponents();
        
        DefaultTableModel a = (DefaultTableModel) jTable1.getModel();
        a.setRowCount(0);
        Frame.arbolUsr.postOrden(Frame.arbolUsr.getRoot(), a);
        jTable1.setModel(a);
         
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Pre Orden");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("In Orden");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Post Orden");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(330, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(147, 147, 147))
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jButton2)
                .addGap(26, 26, 26)
                .addComponent(jButton3)
                .addGap(39, 39, 39)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(31, 31, 31))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //arbolUsr.inOrden(Interprete.arbolUsr.getRoot());
        int fila = jTable1.getSelectedRow();
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
         Object st = dtm.getValueAt(fila, 0);
         String idUsr = (String) st;
         Usuario usuario = new Usuario();
         usuario.setUsuario(idUsr);
         usuario = Frame.arbolUsr.find(usuario, Frame.arbolUsr.getRoot()).getValue();
         
         Imagen i = new Imagen(usuario.getImgsInt().getPrimero().getValue());
          com.mycompany.edd_practica_2.listas.Nodo<Imagen> n = Frame.lstCircular.find(i);
          if (n != null) {
            
              i= n.getValue();
              String cadena = i.getCapas().getPrimero().getValue().mostrarCadena();
              WriteFile wf = new WriteFile();
              wf.writeFile(usuario.getUsuario()+".dot", cadena);
              wf.dibujar(usuario.getUsuario()+".dot", usuario.getUsuario()+".png");
              loadImage(usuario.getUsuario()+".png");
        }
         
         Frame.arbolUsr.find(usuario, Frame.arbolUsr.getRoot());
    }//GEN-LAST:event_jButton1ActionPerformed

       public void loadImage(String path) {
        File file = new File(path);
        if (file.exists()) {
            LoadImage imagen = new LoadImage(file.getAbsolutePath());
            paneRoot.removeAll();
            paneRoot.add(imagen);
            paneRoot.repaint();
        }else
            JOptionPane.showMessageDialog(null, "Error Al Cargar la Imagen","Informacion",JOptionPane.ERROR_MESSAGE);

    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         DefaultTableModel a = (DefaultTableModel) jTable1.getModel();
        a.setRowCount(0);
        Frame.arbolUsr.preOrden(Frame.arbolUsr.getRoot(), a);
        
         jTable1.setModel(a);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         DefaultTableModel a = (DefaultTableModel) jTable1.getModel();
        a.setRowCount(0);
        Frame.arbolUsr.inOrden(Frame.arbolUsr.getRoot(), a);
        
         jTable1.setModel(a);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         DefaultTableModel a = (DefaultTableModel) jTable1.getModel();
        a.setRowCount(0);
        Frame.arbolUsr.postOrden(Frame.arbolUsr.getRoot(), a);
        
         jTable1.setModel(a);
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
