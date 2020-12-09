/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menucomidas;

import com.mysql.jdbc.Blob;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Miguel Ruiz
 */
public class Platillos extends javax.swing.JFrame {

    String titulos[] = {"Nombre", "Tipo", "Imagen", "Postre"};
    Object fila[] = new Object[4];
    
    DefaultTableModel modelo;
    Statement stmt = null;

    public Platillos() {
        initComponents();
        //COMANDO PARA HACER GRANDE LA GUI.
        setExtendedState(MAXIMIZED_BOTH);
        consultaComida(tblComida);
    }

    public void consultaComida(JTable tabla) {
        Connection conexion = Conexion.getConnection();
        tabla.setDefaultRenderer(Object.class, new TablaImagen());
        try {
            if (conexion != null) {
                System.out.println("Se ha establecido una conexion con la base de datos" + "\n" + "Menu");
            }
            stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT nombre_comi, tipo_comi,imagen_comi,imagen_post FROM comida JOIN postre");
            modelo = new DefaultTableModel(null, titulos);
            while (rs.next()) {
                fila[0] = rs.getObject("nombre_comi");
                fila[1] = rs.getObject("tipo_comi");
                //Comida
                /*
                java.sql.Blob blob = rs.getBlob(3);

                byte[] data = blob.getBytes(1, (int) blob.length());
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new ByteArrayInputStream(data));
                } catch (Exception ex) {
                }
                ImageIcon icono = new ImageIcon(img);

                //fila[2] = new JLabel(icono);
                //row[1] = new JLabel(icono);
                //fila[2] = icono;

                //Postre
                java.sql.Blob blob1 = rs.getBlob(3);

                byte[] data1 = blob.getBytes(1, (int) blob1.length());
                BufferedImage img1 = null;
                try {
                    img = ImageIO.read(new ByteArrayInputStream(data1));
                } catch (Exception ex) {
                    
                }
                ImageIcon icono1 = new ImageIcon(img1);

                //fila[3] = new JLabel(icono1);
                //fila[3] = icono1;
                */

                modelo.addRow(fila);
            }
            tblComida.setModel(modelo);
            tblComida.setRowHeight(64);
            
            TableColumn cn = tblComida.getColumn("Nombre");
            TableColumn ct = tblComida.getColumn("Tipo");
            //TableColumn ci = tblComida.getColumn("Imagen");
            //TableColumn cp = tblComida.getColumn("Postre");
        } catch (SQLException e) {
            System.out.println("Error al visualizar en la tabla " +e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblComida = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblComplemento = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblComida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblComida);
        if (tblComida.getColumnModel().getColumnCount() > 0) {
            tblComida.getColumnModel().getColumn(2).setMinWidth(100);
            tblComida.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        tblComplemento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblComplemento);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("HACER PLATILLOS");

        btnAgregar.setText("AGREGAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(411, 411, 411)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(456, 456, 456)
                        .addComponent(btnAgregar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(btnAgregar)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Platillos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Platillos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Platillos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Platillos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Platillos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblComida;
    private javax.swing.JTable tblComplemento;
    // End of variables declaration//GEN-END:variables
}
