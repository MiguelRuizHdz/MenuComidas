/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menucomidas;



import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
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
public class VisualizarTablas {
    
    public void visualizar_tablaComida(JTable tblComida){
        Connection conexion = Conexion.getConnection();
        tblComida.setDefaultRenderer(Object.class, new TablaImagen());
        
        String titulos[] = {"Nombre", "Tipo", "Imagen", "Postre"};
        Object fila[] = new Object[4];
        DefaultTableModel modelo = new DefaultTableModel();
        Statement stmt = null;
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
                java.sql.Blob blob = rs.getBlob(3);

                byte[] data = blob.getBytes(1, (int) blob.length());
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new ByteArrayInputStream(data));
                } catch (Exception ex) {
                }
                ImageIcon icono = new ImageIcon(img);

                fila[2] = new JLabel(icono);

                //Postre
                java.sql.Blob blob1 = rs.getBlob(3);

                byte[] data1 = blob.getBytes(1, (int) blob1.length());
                BufferedImage img1 = null;
                try {
                    img = ImageIO.read(new ByteArrayInputStream(data1));
                } catch (Exception ex) {
                    
                }
                ImageIcon icono1 = new ImageIcon(img1); 

                fila[3] = new JLabel(icono1);
                

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
    
}
