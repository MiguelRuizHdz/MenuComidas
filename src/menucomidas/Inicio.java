/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menucomidas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Miguel Ruiz
 */
public class Inicio extends javax.swing.JFrame {

    //VARIABLES DE BARRA
    JMenuBar barra;
    JMenu menu_ver_menu;
    JMenu menu_alimentos;
    JMenu menu_platillo;
    JMenuItem menuItem_menu;
    JMenuItem menuItem_comida;
    JMenuItem menuItem_complemento;
    JMenuItem menuItem_hacer_platillo;

    private void crearMenu() {
        barra = new JMenuBar();
        menu_ver_menu = new JMenu("Menú");
        menu_alimentos = new JMenu("Alimentos");
        menu_platillo = new JMenu("Platillo");
        menuItem_menu = new JMenuItem("Ver menú");
        menuItem_comida = new JMenuItem("Agregar comida");
        menuItem_complemento = new JMenuItem("Agregar complemento");
        menuItem_hacer_platillo = new JMenuItem("Hacer platillo");
        menu_ver_menu.add(menuItem_menu);
        menu_alimentos.add(menuItem_comida);
        menu_alimentos.add(menuItem_complemento);
        menu_platillo.add(menuItem_hacer_platillo);
        barra.add(menu_ver_menu);
        barra.add(menu_alimentos);
        barra.add(menu_platillo);
        setJMenuBar(barra);

        //EVENTOS DEL MENU
        menuItem_menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Menu verMenu = new Menu();
                verMenu.setVisible(true);
                verMenu.setLocationRelativeTo(null);
            }
        });
        //EVENTOS DEL MENU
        menuItem_comida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Comidas comida= new Comidas();
                comida.setVisible(true);
            }
        });
        //EVENTOS DEL MENU
        menuItem_complemento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Complementos comp = new Complementos();
                comp.setVisible(true);
                Complementos agregarcomplemento = new Complementos();
                agregarcomplemento.setVisible(true);
                agregarcomplemento.setLocationRelativeTo(null);
            }
        });
        //EVENTOS DEL MENU
        menuItem_hacer_platillo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Platillos hacerplatillo = new Platillos();
                hacerplatillo.setVisible(true);
                hacerplatillo.setLocationRelativeTo(null);
            }
        });
    }
    public Inicio() {
        crearMenu();
        initComponents();
        setTitle("Inicio");
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
